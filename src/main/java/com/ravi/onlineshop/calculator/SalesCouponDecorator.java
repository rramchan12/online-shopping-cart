package com.ravi.onlineshop.calculator;

import com.ravi.onlineshop.bo.component.BaseOrderBo;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class SalesCouponDecorator extends BaseCouponCalculator {


    public SalesCouponDecorator(BaseOrderBo orderBo) {
        super(orderBo);
    }

    @Override
    public int calculateCouponDiscount() {
        //Apply discount rules
        List<OrderDetails> orderDetail = orderBo.getOrderDetails();
        Orders order = orderBo.getOrders();

        log.info("SalesDiscountDecorator : Calculating Discount for OrderId {}", order.getOrderId());
        return 3;
    }


}
