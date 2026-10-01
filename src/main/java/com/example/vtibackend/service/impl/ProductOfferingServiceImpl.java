package com.example.vtibackend.service.impl;

import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.repository.ProductOfferingRepo;
import com.example.vtibackend.service.ProductOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<ProductOfferings> getAll() {
        return productOfferingRepo.findAll();
    }

    @Override
    public List<ProductOfferings> getByName(String name) {
        List<ProductOfferings> product = productOfferingRepo.findByName(name);
        if(product.isEmpty()){
            throw new RuntimeException( name + " is not found!");
        }
        return product;
    }

    @Override
    public List<ProductOfferings> getByNameAndColor(String name, String color) {
        List<ProductOfferings> product = productOfferingRepo.findByNameAndColor(name, color);
        if(product.isEmpty()){
            throw new RuntimeException("Data not found!");
        }
        return product;
    }
}
