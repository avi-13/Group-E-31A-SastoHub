package com.system.sastohub.services;

import com.system.sastohub.entity.MyCart;
import com.system.sastohub.pojo.AddToCartPojo;

import java.util.List;

public interface AddToCartService {

    List<MyCart> fetchAll();
    AddToCartPojo saveToCart(AddToCartPojo addToCartPojo);

    MyCart fetchById(Integer id);
}
