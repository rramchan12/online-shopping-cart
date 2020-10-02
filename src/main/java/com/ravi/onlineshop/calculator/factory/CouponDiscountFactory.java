package com.ravi.onlineshop.calculator.factory;

import com.ravi.onlineshop.bo.component.BaseOrderBo;
import com.ravi.onlineshop.calculator.SalesCouponDecorator;

public class CouponDiscountFactory {


    public enum TYPE{
        SALES_DISCOUNT_TYPE,
        ITEM_DISCOUNT_TYPE
    }
    public static BaseOrderBo getCouponCalculator(TYPE type, BaseOrderBo baseOrderBo){
        if (type==TYPE.SALES_DISCOUNT_TYPE)
                return new SalesCouponDecorator(baseOrderBo);
        else if (type==TYPE.ITEM_DISCOUNT_TYPE)
            throw new UnsupportedOperationException();
        else
            throw new UnsupportedOperationException();
    }

}