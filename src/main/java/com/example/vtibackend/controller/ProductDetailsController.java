package com.example.vtibackend.controller;

import com.example.vtibackend.dto.request.CreatProductDetailReq;
import com.example.vtibackend.entity.ProductDetails;
import com.example.vtibackend.service.ProductDetailsService;
import com.example.vtibackend.service.impl.ProductDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class ProductDetailsController {

    private final ProductDetailsService productDetailsService;

    @GetMapping("/product-detail")
    public ResponseEntity<List<ProductDetails>> getAll(){
        return ResponseEntity.ok(productDetailsService.getAll());
    }

    @PostMapping("/product-detail")
    public ResponseEntity<ProductDetails> create(@RequestBody CreatProductDetailReq request){
        return ResponseEntity.ok(productDetailsService.createDetail(request));
    }
}
