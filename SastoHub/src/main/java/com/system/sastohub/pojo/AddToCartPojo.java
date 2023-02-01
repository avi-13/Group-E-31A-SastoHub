package com.system.sastohub.pojo;

import com.system.sastohub.entity.MyCart;
import com.system.sastohub.entity.Product;
import com.system.sastohub.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartPojo {
    private Integer cart_id;
    private Integer p_id;
    private Integer user_id;
    private String full_name;
    private String ptitle;

    private String pCategories;

    private String pDesc;

    private String bName;

    private String size;

    private double pPrice;

    private MultipartFile image;

    public AddToCartPojo(MyCart myCart){
        this.cart_id= myCart.getCartId();
        this.p_id= myCart.getUser().getId();
        this.user_id= myCart.getProduct().getProductId();
        this.full_name = myCart.getUser().getFull_name();
        this.ptitle=myCart.getProduct().getProductTitle();
        this.pCategories=myCart.getProduct().getProductCategory();
        this.pDesc=myCart.getProduct().getProductDescription();
        this.bName=myCart.getProduct().getBrandName();
        this.size=myCart.getProduct().getSize();
//        this.pPrice= myCart.getProduct().getProductPrice();
    }

}
