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

    //This should be part of Either Orders, Item
    private String field_category;

    //This should be a field of Orders, Item
    private String field_name;
    //The Value of the field
    //TODO There should also be a field called DataType so that proper casting can be done
    private int value;
    //Should be equal to GREATER_THAN, LESS_THAN, EQUALS
    //TODO Right now we will keep it simple and not take >= and other conditions
    private String condition;

    //The discount that can possibly be given on the same
    private int coupon_value;

}
