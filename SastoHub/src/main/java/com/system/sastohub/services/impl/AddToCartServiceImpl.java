package com.system.sastohub.services.impl;

import com.system.sastohub.entity.MyCart;
import com.system.sastohub.pojo.AddToCartPojo;
import com.system.sastohub.repo.AddToCartRepo;
import com.system.sastohub.repo.ProductRepo;
import com.system.sastohub.repo.UserRepo;
import com.system.sastohub.services.AddToCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class AddToCartServiceImpl implements AddToCartService {
    private final AddToCartRepo addToCartRepo;

    private final UserRepo userRepo;

    private final ProductRepo productRepo;

    @Override
    public void saveToCart(AddToCartPojo addToCartPojo) {
        MyCart myCart = new MyCart();

//        if (addToCartPojo.getUser_id()!=null) {
            myCart.setUser(userRepo.findById(addToCartPojo.getUser_id()).orElseThrow());
            myCart.setProduct(productRepo.findById(addToCartPojo.getP_id()).orElseThrow());
//            myCart.setFull_name(userRepo.findById(addToCartPojo.getFull_name()).orElseThrow());
            addToCartRepo.save(myCart);
//        } else {
//            System.out.println("False");
//        }
    }
}
