package com.example.vtibackend.controller;

import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.service.impl.ProductOfferingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductOfferingController {

    @Autowired
    private ProductOfferingServiceImpl productOfferingServiceimpl;

    @GetMapping("/product")
    public ResponseEntity<ProductOfferings> getById(Long id){
        id = 1l;
        ProductOfferings productOfferings = productOfferingServiceimpl.getById(id);
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductOfferings>> getAllProductOfferings(){
        return ResponseEntity.ok(productOfferingServiceimpl.getAll());
    }

    @GetMapping("/products-name")
    public ResponseEntity<List<ProductOfferings>> getAllByName(String name){
        name = "product_1";
        return ResponseEntity.ok(productOfferingServiceimpl.getByName(name));
    }

    @GetMapping("/products-name-color")
    public ResponseEntity<List<ProductOfferings>> getAllByNameAndColor(String name, String color){
        name = "product_1";
        color = "red_1";
        return ResponseEntity.ok(productOfferingServiceimpl.getByNameAndColor(name, color));
    }
}
