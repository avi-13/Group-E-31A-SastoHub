package com.system.sastohub.services.impl;

import com.system.sastohub.entity.Product;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.repo.ProductRepo;
import com.system.sastohub.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/sastohubimages";


    @Override
    public ProductPojo saveProduct(ProductPojo productpojo) throws IOException {
        Product product = new Product();
        if (productpojo.getPid()!= null){
            product.setProductId(productpojo.getPid());
        }
        product.setProductTitle(productpojo.getPtitle());
        product.setProductCategory(productpojo.getPCategories());
        product.setProductDescription(productpojo.getPDesc());
        product.setProductPrice(productpojo.getPPrice());

        if(productpojo.getImage()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, productpojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, productpojo.getImage().getBytes());

            product.setImage(productpojo.getImage().getOriginalFilename());
        }
        productRepo.save(product);
        return new ProductPojo(product);
    }

    @Override
    public Product fetchById(Integer id) {
        return productRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Product> fetchAll() {
        return productRepo.findAll();
    }

}
