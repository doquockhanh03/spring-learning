package com.example.vtibackend.controller;

import com.example.vtibackend.dto.request.CreateProductOfferingReq;
import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.service.ProductOfferingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductOfferingsController {

    @Autowired
    private ProductOfferingsService productOfferingService;

    @GetMapping("/product")
    public ResponseEntity<ProductOfferings> getById(Long id){
        id = 2l;
        ProductOfferings productOfferings = productOfferingService.getById(id);
        return ResponseEntity.ok(productOfferings);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductOfferings>> getAllProductOfferings(){
        return ResponseEntity.ok(productOfferingService.getAll());
    }

    @GetMapping("/products-name")
    public ResponseEntity<List<ProductOfferings>> getAllByName(String name){
        name = "product_1";
        return ResponseEntity.ok(productOfferingService.getByName(name));
    }

    @GetMapping("/products-name-color")
    public ResponseEntity<List<ProductOfferings>> getAllByNameAndColor(String name, String color){
        name = "product_1";
        color = "red_1";
        return ResponseEntity.ok(productOfferingService.getByNameAndColor(name, color));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductOfferings> update(@PathVariable Long id, @RequestBody ProductOfferings productOfferings){
        return ResponseEntity.ok(productOfferingService.updateProduct(id, productOfferings));
    }

    @GetMapping("/product-by-detail/{id}")
    public ResponseEntity<List<ProductOfferings>> getByDetailId(@PathVariable Long id){
        return ResponseEntity.ok(productOfferingService.getByDetailId(id));
    }

    @PostMapping("/product")
    public ResponseEntity<ProductOfferings> create(@RequestBody ProductOfferings productOfferings){
        return ResponseEntity.ok(productOfferingService.createProduct(productOfferings));
    }

    @PostMapping("/productDto")
    public ResponseEntity<ProductOfferings> createDto(@RequestBody CreateProductOfferingReq request){
        return ResponseEntity.ok(productOfferingService.createProductDto(request));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductOfferings>> filter(@RequestParam(name = "name", required = false) String name,
                                                         @RequestParam(name = "minPrice", required = false) Long minPrice,
                                                         @RequestParam(name = "maxPrice", required = false) Long maxPrice,
                                                         @RequestParam(name = "color", required = false) String color,
                                                         @RequestParam(name = "status", required = false) String status){

        List<ProductOfferings> productOfferings = productOfferingService.filter(name, minPrice, maxPrice, color, status);
        return ResponseEntity.ok(productOfferings);
    }
}
