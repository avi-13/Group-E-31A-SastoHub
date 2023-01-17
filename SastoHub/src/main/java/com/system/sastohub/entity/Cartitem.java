package com.system.sastohub.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cartitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private int itemQuantity;

    public Cartitem() {}

    public Cartitem(String itemName, int itemQuantity) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }


}




