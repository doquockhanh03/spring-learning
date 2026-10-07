package com.example.vtibackend.service.impl;

import com.example.vtibackend.dto.request.CreatProductDetailReq;
import com.example.vtibackend.entity.ProductDetails;
import com.example.vtibackend.repository.ProductDetailsRepo;
import com.example.vtibackend.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    ProductDetailsRepo productDetailsRepo;

    @Override
    public List<ProductDetails> getAll() {
        return productDetailsRepo.findAll();
    }

    @Override
    public ProductDetails createDetail(CreatProductDetailReq request) {
        if(request.getWeight() == null || request.getBrand().isEmpty() || request.getFeature().isEmpty() ||
        request.getImage().isEmpty() || request.getPower().isEmpty() || request.getVideo().isEmpty()){
            throw new RuntimeException("Khong duoc trong du lieu!");
        }

        ProductDetails productDetails = new ProductDetails();

        productDetails.setBrand(request.getBrand());
        productDetails.setFeature(request.getFeature());
        productDetails.setImage(request.getImage());
        productDetails.setPower(request.getPower());
        productDetails.setWeight(request.getWeight());
        productDetails.setVideo(request.getVideo());

        return productDetailsRepo.save(productDetails);
    }
}
