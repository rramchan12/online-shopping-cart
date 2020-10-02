package com.ravi.onlineshop.repository;

import com.ravi.onlineshop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByCustomerId(int customer_id);
}
