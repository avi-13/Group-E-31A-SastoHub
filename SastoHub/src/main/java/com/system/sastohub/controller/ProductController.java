package com.system.sastohub.controller;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.services.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/addProduct")
        public String addProduct(Model model){
            model.addAttribute("product", new ProductPojo());
            return "/addproduct";

    }

    @PostMapping("/save")
    public String saveProduct(@Valid ProductPojo productPojo){
        productService.addProduct(productPojo);
        return "redirect:/user/list";
    }


}
