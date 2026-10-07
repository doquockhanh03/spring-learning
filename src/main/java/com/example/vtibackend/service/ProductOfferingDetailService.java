package com.example.vtibackend.service;

import com.example.vtibackend.dto.request.AssignProductDetailReq;
import com.example.vtibackend.entity.ProductOfferings;

public interface ProductOfferingDetailService {

    ProductOfferings assignProductDetail(AssignProductDetailReq request);
}
