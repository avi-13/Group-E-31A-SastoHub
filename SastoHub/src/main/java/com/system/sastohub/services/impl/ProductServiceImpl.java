package com.system.sastohub.services.impl;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.repo.ProductRepo;
import com.system.sastohub.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public String saveProduct(ProductPojo productpojo) {
        Product product = new Product();
        if (productpojo.getPid()!= null){
            product.setProductId(productpojo.getPid());
        }
        product.setProductTitle(productpojo.getPtitle());
        product.setProductCategory(productpojo.getPCategories());
        product.setProductDescription(productpojo.getPDesc());
        product.setProductPrice(productpojo.getPPrice());
        productRepo.save(product);
        return "NewProductAdded";
    }

    @Override
    public Product fetchbyid(Integer id) {
        Product product=productRepo.findById(id).orElseThrow();
        return product;
    }

    @Override
    public List<Product> fetchAll() {
        return productRepo.findAll();
    }

}
