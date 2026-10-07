package com.example.vtibackend.service.impl;

import com.example.vtibackend.dto.request.AssignProductDetailReq;
import com.example.vtibackend.entity.ProductDetails;
import com.example.vtibackend.entity.ProductOfferingDetail;
import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.repository.ProductDetailsRepo;
import com.example.vtibackend.repository.ProductOfferingDetailRepo;
import com.example.vtibackend.repository.ProductOfferingsRepo;
import com.example.vtibackend.service.ProductDetailsService;
import com.example.vtibackend.service.ProductOfferingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductOfferingDetailServiceImpl implements ProductOfferingDetailService {

    @Autowired
    private ProductOfferingDetailRepo productOfferingDetailRepo;

    @Autowired
    private ProductOfferingsRepo productOfferingsRepo;

    @Autowired
    private ProductDetailsRepo productDetailsRepo;

    @Override
    public ProductOfferings assignProductDetail(AssignProductDetailReq request) {
        if(request.getProductOfferingIds() == null){
            throw new RuntimeException("Khong duoc de trong!");
        }

        if(request.getProductDetailIds() == null || request.getProductDetailIds().isEmpty()){
            throw new RuntimeException("Khong duoc trong du lieu!");
        }

        Optional<ProductOfferings> productOfferingsOptinal = productOfferingsRepo.findById(request.getProductOfferingIds());
        if(productOfferingsOptinal.isEmpty()){
            throw new RuntimeException("productOffering not exist!");
        }

        ProductOfferings productOfferings1 = productOfferingsOptinal.get();

        List<ProductDetails> productDetailsList = productDetailsRepo.findAllById(request.getProductDetailIds());
        if(productDetailsList.isEmpty()){
            throw new RuntimeException("productDetail not exist!");
        }

        List<ProductOfferingDetail> productOfferingDetails = new ArrayList<>();

        for(int i = 0; i < productDetailsList.size(); i++){
            ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();
            productOfferingDetail.setProductOfferings(productOfferingsOptinal.get());
            productOfferingDetail.setProductDetails(productDetailsList.get(i));

            productOfferingDetails.add(productOfferingDetail);
        }

        productOfferingDetailRepo.saveAll(productOfferingDetails);
        productOfferings1.setProductOfferingDetails(productOfferingDetails);
        return productOfferings1;
    }
}
