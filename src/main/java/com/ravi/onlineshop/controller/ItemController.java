package com.ravi.onlineshop.controller;

import com.ravi.onlineshop.bo.ItemBo;
import com.ravi.onlineshop.model.Item;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
public class ItemController {

    @Autowired
    ItemBo itemBo;

    @GetMapping
    @ApiOperation(value = "View Items List", notes = "View All Items")
    public List<Item> getByCustomerId(){
        return itemBo.viewItems();
    }



}
