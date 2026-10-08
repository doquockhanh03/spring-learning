package com.example.vtibackend.service;

import com.example.vtibackend.dto.request.CreateProductOfferingReq;
import com.example.vtibackend.entity.ProductOfferingDetail;
import com.example.vtibackend.entity.ProductOfferings;

import java.util.List;

public interface ProductOfferingsService {
    ProductOfferings getById(Long id);

    List<ProductOfferings> getAll();

    List<ProductOfferings> getByName(String name);

    List<ProductOfferings> getByNameAndColor(String name, String color);

    ProductOfferings createProduct(ProductOfferings productOfferings);

    ProductOfferings updateProduct(Long id, ProductOfferings productOfferings);

    List<ProductOfferings> getByDetailId(Long id);

    ProductOfferings createProductDto(CreateProductOfferingReq request);

    List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status);
}
