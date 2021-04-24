package com.example.kpabd_deliveryapp.service;

import com.example.kpabd_deliveryapp.model.Orders;
import com.example.kpabd_deliveryapp.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private boolean canBeDeliveryStatus(String status)
    {
        boolean isDelivered = status.equals("delivered");
        boolean isPending = status.equals("pending");
        boolean isOnTheWay = status.equals("on the way");

        return isDelivered || isPending || isOnTheWay;
    }

    @Autowired
    private final OrdersRepository ordersRepository;

    public List<Orders> getOrders()
    {
        return ordersRepository.findAllOrders();
    }

    public Orders getSingleOrder(Long id)
    {
        return ordersRepository.findById(id).orElseThrow();
    }

    public List<Orders> getDeliveredOrders()
    {
        return ordersRepository.findAllDeliveredOrders();
    }

    public List<Orders> getPendingOrders()
    {
        return ordersRepository.findAllPendingOrders();
    }

    public List<Orders> getOnTheWayOrders()
    {
        return ordersRepository.findAllOnTheWayOrders();
    }

    public Orders addOrder(Orders order)
    {
        System.out.println(order.getDelivery_status());
        if(!canBeDeliveryStatus(order.getDelivery_status())) throw new IllegalArgumentException();

        return ordersRepository.save(order);
    }

    @Transactional
    public Orders editOrder(Orders order)
    {
        Orders orderEdited = ordersRepository.findById(order.getId()).orElseThrow();
        orderEdited.setDelivery_status(order.getDelivery_status());
        return orderEdited;
    }


    public void deleteOrder(long id)
    {
        ordersRepository.deleteById(id);
    }
}

