package com.ravi.onlineshop.controller;

import com.ravi.onlineshop.bo.ItemBo;
import com.ravi.onlineshop.bo.OrdersBo;
import com.ravi.onlineshop.model.Item;
import com.ravi.onlineshop.model.Orders;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrdersController {

    @Autowired
    OrdersBo ordersBo;

    /**
     * Get all the orders of a Customer by Customer Id
     * Useful to close the Status of the order and see older Orders
     * @param customerId The Customer Id in Question
     * @return OrderBo
     */
    @ApiOperation(value ="Get Order Information For Customer", notes="For a Customer ID get all the Orders, provided Customer Id Exists")
    @GetMapping("customer/{customerId}")
    List<Orders> getByCustomerId(@ApiParam(value="Customer Id" , required=true) @PathVariable("customerId")
                int customerId){
        return ordersBo.findOrdersByCustomerId(customerId);
    }


    @ApiOperation(value ="Get Order Information for Order Id", notes="For a Order ID get all the Orders, provided Customer Id Exists")
    @GetMapping("{orderId}")
    Orders getByOrderId(@ApiParam(value="Order Id" , required=true) @PathVariable("orderId")
                                         int orderId){
        return ordersBo.findOrdersByOrderId(orderId);
    }

}






