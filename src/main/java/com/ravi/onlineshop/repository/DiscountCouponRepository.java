package com.ravi.onlineshop.repository;

import com.ravi.onlineshop.model.Customer;
import com.ravi.onlineshop.model.DiscountCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCouponRepository extends JpaRepository<DiscountCoupon, Integer> {

}
