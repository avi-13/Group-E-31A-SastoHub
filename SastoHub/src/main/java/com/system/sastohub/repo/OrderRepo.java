package com.system.sastohub.repo;

import com.system.sastohub.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository <Order , Integer> {

}
