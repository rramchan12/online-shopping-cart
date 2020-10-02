package com.ravi.onlineshop.bo;


import com.ravi.onlineshop.bo.component.BaseOrderBo;
import com.ravi.onlineshop.calculator.factory.CouponDiscountFactory;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import com.ravi.onlineshop.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrdersBo  extends BaseOrderBo {


    @Autowired
    OrdersRepository ordersRepository;
    OrderDetailsBo orderDetailsBo;

    private int orderId;


    public List<Orders> findOrdersByCustomerId(int customerId) {
        log.debug("Viewing Orders Details for Customer Id {}",customerId);
        return ordersRepository.findByCustomerId(customerId);

    }


    public Orders findOrdersByOrderId(int orderId) {
        this.orderId = orderId;
        log.debug("Viewing Orders Details for Customer Id {}",orderId);
        Optional<Orders> orders = ordersRepository.findById(orderId);
        return Optional.ofNullable(orders.get()).orElse(null);

    }


    /**
     *
     *
     * @return The Discount Coupon
     * For a Given Order, evaluate and Get a DiscountCoupon
     */
    public int calculateCouponDiscount(){

        //Factory Class to Call on Discounting
         BaseOrderBo decorator = CouponDiscountFactory.getCouponCalculator(CouponDiscountFactory.TYPE.SALES_DISCOUNT_TYPE, this);
         return decorator.calculateCouponDiscount();

    }

    @Override
    public Orders getOrders() {
            Optional<Orders> orders = ordersRepository.findById(orderId);
            return Optional.ofNullable(orders.get()).orElse(null);
    }

    @Override
    public List<OrderDetails> getOrderDetails() {
        return orderDetailsBo.findOrdersDetailsByOrderId(orderId);
    }



}
