package com.system.sastohub.repo;

import com.system.sastohub.entity.MyCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddToCartRepo extends JpaRepository<MyCart,Integer> {

}
