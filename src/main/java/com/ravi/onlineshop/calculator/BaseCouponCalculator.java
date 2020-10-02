package com.ravi.onlineshop.calculator;

import com.ravi.onlineshop.bo.OrdersBo;
import com.ravi.onlineshop.bo.component.BaseOrderBo;

public abstract class BaseCouponCalculator extends BaseOrderBo
{
    BaseOrderBo orderBo;

    public BaseCouponCalculator(BaseOrderBo orderBo){
        this.orderBo = orderBo;
    }


}
