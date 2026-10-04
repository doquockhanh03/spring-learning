package com.example.vtibackend.service.impl;

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
}
