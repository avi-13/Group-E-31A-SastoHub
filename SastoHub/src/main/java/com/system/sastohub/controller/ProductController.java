package com.system.sastohub.controller;

import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/addProduct")
    public String createProduct(Model model){
        model.addAttribute("product" , new ProductPojo());
        return "/addproduct";

    }

    @PostMapping("/save")
    public String saveProduct(@Valid ProductPojo productPojo){
        productService.saveProduct(productPojo);
        return "redirect:/product/addProduct";
    }

}
