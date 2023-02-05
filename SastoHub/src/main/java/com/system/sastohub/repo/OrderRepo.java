package com.system.sastohub.repo;

import com.system.sastohub.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository <Order , Integer> {

    Optional<Order> findOrderByEmail(String email);
}
