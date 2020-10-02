package com.ravi.onlineshop.couponengine;

import com.ravi.onlineshop.bo.component.BaseOrderBo;

public abstract class BaseCouponCalculator extends BaseOrderBo
{
    BaseOrderBo orderBo;

    public BaseCouponCalculator(BaseOrderBo orderBo){
        this.orderBo = orderBo;
    }


}
