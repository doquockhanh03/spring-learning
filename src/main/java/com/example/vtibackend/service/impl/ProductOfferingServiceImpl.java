package com.example.vtibackend.service.impl;

import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.repository.ProductOfferingRepo;
import com.example.vtibackend.service.ProductOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOfferingServiceImpl implements ProductOfferingService {

    @Autowired
    private ProductOfferingRepo productOfferingRepo;

    @Override
    public ProductOfferings getById(Long id) {
        Optional<ProductOfferings> product = productOfferingRepo.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("product is empty!");
        }
        return product.get();
    }
}
