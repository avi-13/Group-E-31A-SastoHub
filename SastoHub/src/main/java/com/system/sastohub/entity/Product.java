package com.system.sastohub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    @Id
    @SequenceGenerator(name = "shb_product_seq_gen", sequenceName = "shb_product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shb_product_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "ProductId")
    private Integer productId;

    @Column(name = "ProductTitle")
    private String productTitle;
    @Column(name = "ProductCategory")
    private String productCategory;

    @Column(name = "ProductDescription")
    private String productDescription;

    @Column(name = "ProductPrice")
    private double productPrice;
}
