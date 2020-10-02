package com.ravi.onlineshop.bo;

import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import com.ravi.onlineshop.repository.OrdersDetailsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class OrderDetailsBo {


    @Autowired
    OrdersDetailsRepository ordersDetailsRepository;


    public List<OrderDetails> findOrdersDetailsByOrderId(int orderId) {
        log.debug("Viewing Orders Details for Order Id {}",orderId);
        return ordersDetailsRepository.findById(orderId);

    }
}
