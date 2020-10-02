package com.ravi.onlineshop.repository;

import com.ravi.onlineshop.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    List<OrderDetails> findById(int order_id);

    OrderDetails findByOrderIdAndAndItemNbr(int order_id, int item_nbr);
}
