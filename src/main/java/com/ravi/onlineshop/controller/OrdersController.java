package com.ravi.onlineshop.controller;

import com.ravi.onlineshop.bo.ItemBo;
import com.ravi.onlineshop.bo.OrdersBo;
import com.ravi.onlineshop.model.Item;
import com.ravi.onlineshop.model.OrderDetails;
import com.ravi.onlineshop.model.Orders;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "Place Order", notes = "Assumption is that the order ID exists")
    @PutMapping("{orderId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<OrderDetails> placeOrder(@ApiParam(value = "Order ID", required = true) @PathVariable("orderId") int orderId) {
        return ordersBo.placeOrder(orderId);
    }

}






