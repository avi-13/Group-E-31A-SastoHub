package com.system.sastohub.repo;

import com.system.sastohub.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product, Integer>{
}
