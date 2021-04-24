package com.example.kpabd_deliveryapp.controller;

import com.example.kpabd_deliveryapp.model.Orders;
import com.example.kpabd_deliveryapp.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class OrdersRestController {

    private final OrdersService ordersService;

    @GetMapping("/api/orders")
    public List<Orders> getOrders()
    {
        return ordersService.getOrders();
    }

    @GetMapping("/api/orders/delivered")
    public List<Orders> getDeliveredOrders()
    {
        return ordersService.getDeliveredOrders();
    }

    @GetMapping("/api/orders/pending")
    public List<Orders> getPendingOrders()
    {
        return ordersService.getPendingOrders();
    }

    @GetMapping("/api/orders/onetheway")
    public List<Orders> getOnTheWayOrders()
    {
        return ordersService.getOnTheWayOrders();
    }

    @GetMapping("/api/order/{id}")
    public Orders getSingleOrder(@PathVariable long id)
    {
        return ordersService.getSingleOrder(id);
    }

    @PostMapping("/api/order")
    public Orders addOrder(@RequestBody Orders order)
    {
        return ordersService.addOrder(order);
    }

    @PutMapping("/api/order")
    public Orders editOrder(@RequestBody Orders order)
    {
        return ordersService.editOrder(order);
    }

    @DeleteMapping("api/order/{id}")
    public void deleteOrder(@PathVariable long id)
    {
        ordersService.deleteOrder(id);
    }
}
