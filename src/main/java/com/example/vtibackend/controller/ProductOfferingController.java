package com.example.vtibackend.controller;

import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.service.impl.ProductOfferingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOfferingController {

    @Autowired
    private ProductOfferingServiceImpl productOfferingServiceimpl;

    @GetMapping("/products")
    public ResponseEntity<ProductOfferings> getById(Long id){
        id = 1l;
        ProductOfferings productOfferings = productOfferingServiceimpl.getById(id);
        return ResponseEntity.ok(productOfferings);
    }

}
