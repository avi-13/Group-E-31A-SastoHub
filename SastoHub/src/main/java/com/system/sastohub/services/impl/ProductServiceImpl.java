package com.system.sastohub.services.impl;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Override
    public String addProduct(ProductPojo productPojo) {
        Product product = new Product();
        product.setProductId(productPojo.getPid());
        product.setProductTitle(productPojo.getPtitle());
        product.setProductCategory(productPojo.getPCategories());
        product.setProductDescription(productPojo.getPDesc());

        return "NewProductAdded";
    }

}
