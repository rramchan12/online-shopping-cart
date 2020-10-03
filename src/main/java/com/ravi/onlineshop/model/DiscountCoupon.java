package com.ravi.onlineshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DiscountCoupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coupon_id;
    //TODO This is primarily usedful for nested conditions like ITEM = "Sandals" AND TOTAL_COST < 30 Then apply a conditions
    //For now we will keep it simple
    private int child_coupon_id;

    //Filter out which Orders this Coupon Category Applies to
    //For now ORDER, ITEM or *
    private String field_category;

    //A Subfilter to further drill down on specific field
    //Eg ITEM = "Sandals"
    private String field_name;
    //The Value of the field
    //TODO There should also be a field called DataType so that proper casting can be done
    private int value;
    //Should be equal to GREATER_THAN, LESS_THAN, EQUALS
    //TODO Right now we will keep it simple and not take >= and other conditions
    private String condition;

    //The Decorator that applies for Detailed Calculation
    private String coupon_calculator_code;

}
