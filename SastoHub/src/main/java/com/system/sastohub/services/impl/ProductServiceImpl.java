package com.system.sastohub.services.impl;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.repo.ProductRepo;
import com.system.sastohub.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public String saveProduct(ProductPojo productPojo) {
        Product product = new Product();
        if (productPojo.getPid()!= null){
            product.setProductId(productPojo.getPid());
        }
        product.setProductTitle(productPojo.getPtitle());
        product.setProductCategory(productPojo.getPCategories());
        product.setProductDescription(productPojo.getPDesc());
        product.setProductPrice(productPojo.getPPrice());
        productRepo.save(product);
        return "NewProductAdded";
    }

}
