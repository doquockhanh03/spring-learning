package com.example.vtibackend.controller;

import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.service.impl.ProductOfferingsServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductOfferingsController {

    @Autowired
    private ProductOfferingsServiceImpl productOfferingServiceimpl;

    @GetMapping("/product")
    public ResponseEntity<ProductOfferings> getById(Long id){
        id = 2l;
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

    @PostMapping("/product")
    public ResponseEntity<ProductOfferings> create(@RequestBody ProductOfferings productOfferings){
        return ResponseEntity.ok(productOfferingServiceimpl.createProduct(productOfferings));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductOfferings> update(@PathVariable Long id, @RequestBody ProductOfferings productOfferings){
        return ResponseEntity.ok(productOfferingServiceimpl.updateProduct(id, productOfferings));
    }

    @GetMapping("/product-by-detail/{id}")
    public ResponseEntity<List<ProductOfferings>> getByDetailId(@PathVariable Long id){
        return ResponseEntity.ok(productOfferingServiceimpl.getByDetailId(id));
    }
}
