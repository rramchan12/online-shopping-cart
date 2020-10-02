package com.ravi.onlineshop.bo.component;

import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;

import java.util.List;
import java.util.Optional;

public abstract class BaseOrderBo {


    public abstract int calculateCouponDiscount();
    public   Orders getOrders(){
        return null;
    }
    public  List<OrderDetails> getOrderDetails(){
        return null;
    }

}
