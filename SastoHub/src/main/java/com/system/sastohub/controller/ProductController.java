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
    public String createProduct(Model model){
        model.addAttribute("product" , new ProductPojo());
        return "/addproduct";

    }

    @PostMapping("/save")
    public String saveProduct(@Valid ProductPojo productPojo){
        productService.saveProduct(productPojo);
        return "redirect:/product/addProduct";
    }

    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable Integer id, Model model){
        Product product= productService.fetchbyid(id);
        model.addAttribute("product", product);
        return "browseproduct";

    }

    @GetMapping("/list")
    public String productList(Model model){
        List <Product> products=productService.fetchAll();
        model.addAttribute("product",products);
        return "productlist";
    }

}
