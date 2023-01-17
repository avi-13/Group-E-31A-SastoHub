package com.system.sastohub.services;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;

public interface ProductService {
    String saveProduct(ProductPojo productPojo);
    Product fetchbyid(Integer id);
}
