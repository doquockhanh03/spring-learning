package com.example.vtibackend.controller;

import com.example.vtibackend.dto.request.AssignProductDetailReq;
import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.service.ProductOfferingDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductOfferingDetailController {

    private final ProductOfferingDetailService productOfferingDetailService;

    @PostMapping("assign-product-detail")
    public ResponseEntity<ProductOfferings> assignProductDetail(@RequestBody AssignProductDetailReq request){
        return ResponseEntity.ok(productOfferingDetailService.assignProductDetail(request));
    }
}
