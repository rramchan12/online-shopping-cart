package com.ravi.onlineshop.bo;


import com.ravi.onlineshop.bo.component.BaseOrderBo;
import com.ravi.onlineshop.couponengine.factory.CouponDiscountFactory;
import com.ravi.onlineshop.model.DiscountCoupon;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import com.ravi.onlineshop.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ravi.onlineshop.couponengine.factory.CouponDiscountFactory.TYPE;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrdersBo  extends BaseOrderBo {



    OrdersRepository ordersRepository;
    OrderDetailsBo orderDetailsBo;
    CouponBo couponBo;

    /**
     * Parameterised Constructor to initialize variables
     */
    @Autowired
    public OrdersBo(OrdersRepository ordersRepository, OrderDetailsBo orderDetailsBo, CouponBo couponBo){
        this.ordersRepository = ordersRepository;
        this.orderDetailsBo=orderDetailsBo;
        this.couponBo = couponBo;
    }

    private int orderId;
    private Orders order;
    private List<OrderDetails> orderDetails;

    /**
     * Find all the Orders of a Customer by   CustomerId
     * @param customerId
     * @return
     */
    public List<Orders> findOrdersByCustomerId(int customerId) {
        log.debug("Viewing Orders Details for Customer Id {}",customerId);
        return ordersRepository.findByCustomerId(customerId);

    }

    /**
     * Find the Order by OrderID
     * @param orderId
     * @return
     */
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
        order.setDiscountCouponValue(coupon);
        ordersRepository.save(order);

        return orderDetailsBo.findOrdersDetailsByOrderId(orderId);
    }

    /**
     *
     * Get the  Applicable Discount for an Order
     *
     * @return The Discount Coupon
     * Get Applicable Coupon Factories which need to be evaluated
     * For Each Factory
     *    For a Given Order, evaluate and Get a DiscountCoupon
     */
    public int calculateCouponDiscount(){

        List<DiscountCoupon> discountCoupons = couponBo.getApplicableDiscountCouponCategory();

        int discountPercentage = 0;
        for (DiscountCoupon discountCoupon : discountCoupons) {
            TYPE type = TYPE.valueOf(discountCoupon.getCoupon_calculator_code());
            log.info("Type of Factory to be Instantiated {}",type.toString());
            //Factory Class to Call on Discounting
            BaseOrderBo decorator = CouponDiscountFactory.getCouponCalculator(type, this);
            discountPercentage = discountPercentage+  decorator.calculateCouponDiscount();
        }
        return discountPercentage;

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
