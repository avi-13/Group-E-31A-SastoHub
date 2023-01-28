package com.system.sastohub.controller;

import com.system.sastohub.pojo.AddToCartPojo;
import com.system.sastohub.repo.AddToCartRepo;
import com.system.sastohub.services.AddToCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class AddToCartController {

    private final AddToCartService addToCartService;

    @PostMapping("/mycart")
    public String saveToCart(@Valid AddToCartPojo addToCartPojo){
        addToCartService.saveToCart(addToCartPojo);
        return "redirect:/product/list";
    }
}
