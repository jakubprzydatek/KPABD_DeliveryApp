package com.example.kpabd_deliveryapp.repository;

import com.example.kpabd_deliveryapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("Select o From Orders o")
    List<Orders> findAllOrders();

    @Query("Select o From Orders o Where o.delivery_status like 'delivered'")
    List<Orders> findAllDeliveredOrders();

    @Query("Select o From Orders o Where o.delivery_status like 'pending'")
    List<Orders> findAllPendingOrders();

    @Query("Select o From Orders o Where o.delivery_status like 'on the way'")
    List<Orders> findAllOnTheWayOrders();
}
