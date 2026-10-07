package com.example.vtibackend.controller;

import com.example.vtibackend.dto.request.CreatProductDetailReq;
import com.example.vtibackend.entity.ProductDetails;
import com.example.vtibackend.service.ProductDetailsService;
import com.example.vtibackend.service.impl.ProductDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductDetailsController {

    @Autowired
    ProductDetailsServiceImpl productDetailsServiceImpl;

    @GetMapping("/product-detail")
    public ResponseEntity<List<ProductDetails>> getAll(){
        return ResponseEntity.ok(productDetailsServiceImpl.getAll());
    }

    @PostMapping("/product-detail")
    public ResponseEntity<ProductDetails> create(@RequestBody CreatProductDetailReq request){
        return ResponseEntity.ok(productDetailsServiceImpl.createDetail(request));
    }
}
