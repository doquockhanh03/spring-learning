package com.example.vtibackend.service;

import com.example.vtibackend.dto.request.CreatProductDetailReq;
import com.example.vtibackend.entity.ProductDetails;

import java.util.List;

public interface ProductDetailsService {
    List<ProductDetails> getAll();

    ProductDetails createDetail(CreatProductDetailReq request);
}
