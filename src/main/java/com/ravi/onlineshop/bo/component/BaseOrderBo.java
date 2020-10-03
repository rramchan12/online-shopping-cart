package com.ravi.onlineshop.bo.component;

import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;

import java.util.List;
import java.util.Optional;

/**
 * The Component Class for the Decorator
 * This class holds all the information required to calculate the Discount
 *
 */
public abstract class BaseOrderBo {


    public abstract int calculateCouponDiscount();
    public   Orders getOrders(){
        return null;
    }
    public  List<OrderDetails> getOrderDetails(){
        return null;
    }

}
