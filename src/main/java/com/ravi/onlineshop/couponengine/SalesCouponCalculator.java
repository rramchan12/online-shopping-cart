package com.ravi.onlineshop.couponengine;

import com.ravi.onlineshop.bo.component.BaseOrderBo;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SalesCouponCalculator extends BaseCouponCalculator {


    public SalesCouponCalculator(BaseOrderBo orderBo) {
        super(orderBo);
    }

    @Override
    public int calculateCouponDiscount() {
        //Apply discount rules
        List<OrderDetails> orderDetail = orderBo.getOrderDetails();
        int discount=0;
        Orders order = orderBo.getOrders();

        log.info("SalesDiscountDecorator : Calculating Discount for OrderId {}", order.getOrderId());
        if (order.getTotal() > 3000)
            discount= order.getDiscountCouponValue() + 10;
        else if (order.getTotal() < 1000)
            discount= order.getDiscountCouponValue() + 5;

        return discount;
    }
}
