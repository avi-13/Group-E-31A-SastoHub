package com.system.sastohub.pojo;

import com.system.sastohub.entity.Order;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPojo {

    private Integer orderId;
    private Date orderDate;

    private boolean isDelivered;

    private Integer pid;

    private Integer id;

    private Integer quantity;

    private String email;

    private String address;

    private String mobile_no;

    private String fullname;


    private String ptitle;

    private String pCategories;

    private double pPrice;

    private String size;


    private MultipartFile image;



    public OrderPojo( Order order) {
        this.orderId = order.getOrderId();
        this.orderDate = order.getOrderDate();
        this.isDelivered = order.isOrderDelivered();
        this.pid = order.getProduct().getProductId();
        this.id = order.getUser().getId();
        this.quantity = order.getQuantity();
        this.email = order.getUser().getEmail();
        this.address = order.getUser().getAddress();
        this.mobile_no = order.getUser().getMobileNo();
        this.fullname = order.getUser().getFull_name();
        this.ptitle= order.getProduct().getProductTitle();
        this.pCategories = order.getProduct().getProductCategory();
        this.pPrice = order.getProduct().getProductPrice();
        this.size = order.getProduct().getSize();
    }
}
