package com.system.sastohub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ADDtoccartController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ADDtoccartController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addToCart(String itemName, int quantity) {
        String sql = "INSERT INTO cart (item_name, item_quantity) VALUES (?, ?)";
        jdbcTemplate.update(sql, itemName, quantity);
    }
}
