package com.system.sastohub.services;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;

import java.util.List;

public interface ProductService {
    String saveProduct(ProductPojo productpojo);

    Product fetchbyid(Integer id);

    List <Product> fetchAll();

}
