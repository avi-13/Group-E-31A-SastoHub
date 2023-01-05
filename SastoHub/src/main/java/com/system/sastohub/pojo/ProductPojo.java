package com.system.sastohub.pojo;

import com.system.sastohub.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPojo {
    private Integer pid;

    private String ptitle;

    private String pCategories;

    private String pDesc;


    public ProductPojo(Product product){
        this.pid=product.getProductId();
        this.ptitle=product.getProductTitle();
        this.pCategories= product.getProductCategory();
        this.pDesc = product.getProductDescription();
    }
}
