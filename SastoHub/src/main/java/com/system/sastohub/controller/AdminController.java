package com.system.sastohub.controller;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.pojo.UserPojo;
import com.system.sastohub.services.ProductService;
import com.system.sastohub.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;

//
//    @GetMapping("/product")
//    public String homePage() {
//        return "adminproductlist";
//    }



    @GetMapping("/list")
    public String getproductList(Model model){
        List<Product> adminproduct=productService.fetchAll();
        model.addAttribute("product", adminproduct.stream().map(product ->
                Product.builder()
                        .productId(product.getProductId())
                        .imageBase64(getImageBase64(product.getImage()))
                        .productTitle(product.getProductTitle())
                        .productCategory(product.getProductCategory())
                        .productDescription(product.getProductDescription())
                        .productPrice(product.getProductPrice())
                        .build()

        ));
        return "productlist";
    }


    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/sastohubimages/";
        File file = new File(filePath + fileName);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    @GetMapping("/product/{id}")
    public String fetchById(@PathVariable Integer id, Model model){
        Product product= productService.fetchById(id);
        model.addAttribute("products", new ProductPojo(product));
//        model.addAttribute("productdata", productService.fetchById(principal.getName())
        model.addAttribute("product", product);
        return "deleteproduct";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        Product product =productService.fetchById(id);
        model.addAttribute("product", new ProductPojo(product));
        return "redirect:/product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        productService.deleteById(id);
        return "redirect:/product/list";
    }
}

