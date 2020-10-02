package com.ravi.onlineshop.controller;

import com.ravi.onlineshop.bo.CartBo;
import com.ravi.onlineshop.model.OrderDetails;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class CartController {

    @Autowired
    CartBo cartBo;

    /**
     * REST method to get all orders by  Customer ID
     * @param customerId - The Customer ID
     * @return List of all the orders related to that Customer Id
     */

    @ApiOperation(value = "Return the Cart Details" ,notes= "The Customer ID must exist. This is the assumption for simplification")
    @GetMapping("customer/{customerId}")
     public List<OrderDetails> getCartDetails(@ApiParam(value = "Customer ID", required= true) @PathVariable("customerId") int customerId){
        return cartBo.getShoppingCart(customerId);
    }


}
