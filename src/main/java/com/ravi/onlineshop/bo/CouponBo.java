package com.ravi.onlineshop.bo;

import com.ravi.onlineshop.model.DiscountCoupon;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import com.ravi.onlineshop.repository.DiscountCouponRepository;
import com.ravi.onlineshop.repository.OrdersDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CouponBo {

    @Autowired
    DiscountCouponRepository discountCouponRepository;



    /**
     * Get all the Discount Coupons which can then be filtered to see if a Discount is Applicable
     * We can also filter by sub  Queries, but will keep it simple for now
     * @return The List of Discount Coupons
     */
    public List<DiscountCoupon> getDiscountCoupons(){
        List<DiscountCoupon> discountCoupons;
        discountCoupons=  discountCouponRepository.findAll();
        return discountCoupons;
    }
}
