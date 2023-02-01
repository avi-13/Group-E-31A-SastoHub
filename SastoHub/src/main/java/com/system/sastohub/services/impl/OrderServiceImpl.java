package com.system.sastohub.services.impl;

import com.system.sastohub.entity.Order;
import com.system.sastohub.pojo.OrderPojo;
import com.system.sastohub.repo.OrderRepo;
import com.system.sastohub.repo.ProductRepo;
import com.system.sastohub.repo.UserRepo;
import com.system.sastohub.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.system.sastohub.services.impl.ProductServiceImpl.UPLOAD_DIRECTORY;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    private final UserRepo userRepo;

    private final ProductRepo productRepo;

    @Override
    public OrderPojo saveOrder(OrderPojo orderPojo) throws IOException {
        Order order = new Order();

        order.setOrderId(orderPojo.getOrderId());
        order.setOrderDate(orderPojo.getOrderDate());
        order.setProduct(productRepo.findById(orderPojo.getPid()).orElseThrow());
        order.setUser(userRepo.findById(orderPojo.getId()).orElseThrow());
        order.setQuantity(orderPojo.getQuantity());
        order.setEmail(orderPojo.getFullname());
        order.setEmail(orderPojo.getEmail());
        order.setAddress(orderPojo.getAddress());
        order.setMobileNo(orderPojo.getMobile_no());
        order.setFull_name(orderPojo.getFullname());
        order.setProductTitle(orderPojo.getPtitle());
        order.setProductCategory(orderPojo.getPCategories());
        order.setProductPrice(order.getProductPrice());
        order.setSize(order.getSize());

        if(orderPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, orderPojo.getImage().getOriginalFilename());
            fileNames.append(orderPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, orderPojo.getImage().getBytes());

            order.setImage(orderPojo.getImage().getOriginalFilename());
        }

        orderRepo.save(order);
        return new OrderPojo(order);
    }

    @Override
    public List<Order> fetchAll() {
       return this.orderRepo.findAll();
    }
}
