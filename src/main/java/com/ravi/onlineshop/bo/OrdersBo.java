package com.ravi.onlineshop.bo;


import com.ravi.onlineshop.bo.component.BaseOrderBo;
import com.ravi.onlineshop.couponengine.factory.CouponDiscountFactory;
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



    OrdersRepository ordersRepository;
    OrderDetailsBo orderDetailsBo;

    /**
     * Parameterised Constructor to initialize variables
     */
    @Autowired
    public OrdersBo(OrdersRepository ordersRepository, OrderDetailsBo orderDetailsBo){
        this.ordersRepository = ordersRepository;
        this.orderDetailsBo=orderDetailsBo;
    }

    private int orderId;
    private Orders order;
    private List<OrderDetails> orderDetails;


    public List<Orders> findOrdersByCustomerId(int customerId) {
        log.debug("Viewing Orders Details for Customer Id {}",customerId);
        return ordersRepository.findByCustomerId(customerId);

    }


    public Orders findOrdersByOrderId(int orderId) {
        this.orderId = orderId;
        log.info("Viewing Orders Details for Customer Id {}",orderId);
        Optional<Orders> orders = ordersRepository.findById(orderId);
        return Optional.ofNullable(orders.get()).orElse(null);

    }


    /** Method to place an Order with items in the cart
     * @param orderId - the order (Cart) ID in question
     * @return - All the {@code OrderDetails} in the cart
     */
    public List<OrderDetails> placeOrder(int orderId) {
        log.info("Placing Order {}", orderId);

        Orders order = ordersRepository.findById(orderId).get();
        List<OrderDetails> orderDetails = orderDetailsBo.findOrdersDetailsByOrderId(order.getOrderId());
        order.setStatus(1);
        this.order = order;
        this.orderDetails = orderDetails;
        int coupon = calculateCouponDiscount();
        order.setDiscount_coupon_code(coupon);
        ordersRepository.save(order);

        return orderDetailsBo.findOrdersDetailsByOrderId(orderId);
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
            return this.order;
    }

    @Override
    public List<OrderDetails> getOrderDetails() {
        return this.orderDetails;
    }



}
