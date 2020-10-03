package com.ravi.onlineshop.bo;

import com.ravi.onlineshop.model.DiscountCoupon;
import com.ravi.onlineshop.repository.DiscountCouponRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CouponBo {

    @Autowired
    DiscountCouponRepository discountCouponRepository;

    /**
     * Find a High Level Coupon Category to which the Coupon Discount Applies
     * The value is then passed to the applicable Coupon Calculator for further processing
     * @return The List of Discount Coupons
     */
    public List<DiscountCoupon> getApplicableDiscountCouponCategory(){
        List<DiscountCoupon> discountCoupons;
        discountCoupons=  discountCouponRepository.findAll();
        return discountCoupons;
    }




}
