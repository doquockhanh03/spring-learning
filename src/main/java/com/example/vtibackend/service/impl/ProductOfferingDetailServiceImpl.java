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

import java.util.*;

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
            throw new RuntimeException("ProductOffering id is null");
        }
        if(request.getProductDetailIds() == null || request.getProductDetailIds().isEmpty()){
            throw new RuntimeException("ProductDetail id are null or empty");
        }

        //check duplicate input data
        Set<Long> productDetailsIds = new LinkedHashSet<>(request.getProductDetailIds());

        Optional<ProductOfferings> productOfferingsOptional = productOfferingsRepo.findById(request.getProductOfferingIds());
        if(productOfferingsOptional.isEmpty()){
            throw new RuntimeException("ProductOffering id not exist");
        }

        ProductOfferings productOfferings = productOfferingsOptional.get();

        List<ProductDetails> productDetails = productDetailsRepo.findAllById(productDetailsIds);
        if(productDetails.isEmpty()){
            throw new RuntimeException("ProductDetail id not exist");
        }

        List<ProductOfferingDetail> productOfferingDetails = new ArrayList<>();
        List<ProductOfferingDetail> productOfferingDetailExist = productOfferingDetailRepo.findByProductOfferingsId(request.getProductOfferingIds());

        for(int i = 0; i < productDetails.size(); i++){
            ProductOfferingDetail productOfferingDetail = new ProductOfferingDetail();

            boolean checkExist = false;

            for(int j = 0; j < productOfferingDetailExist.size(); j++){
                ProductOfferingDetail existing = productOfferingDetailExist.get(j);

                if(existing.getProductDetails().getId().equals(productDetails.get(i).getId())){
                    checkExist = true;
                    break;
                }
            }
            if(!checkExist){
                productOfferingDetail.setProductOfferings(productOfferingsOptional.get());
                productOfferingDetail.setProductDetails(productDetails.get(i));

                productOfferingDetails.add(productOfferingDetail);
            }
        }
        productOfferingDetailRepo.saveAll(productOfferingDetails);
        productOfferings.setProductOfferingDetails(productOfferingDetails);
        return productOfferings;
    }
}
