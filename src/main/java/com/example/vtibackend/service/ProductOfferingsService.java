package com.example.vtibackend.service;

import com.example.vtibackend.dto.request.CreateProductOfferingReq;
import com.example.vtibackend.dto.request.ProductOfferingFilterReq;
import com.example.vtibackend.dto.response.ProductOfferingRes;
import com.example.vtibackend.entity.ProductOfferings;
import org.springframework.data.domain.Page; // THÊM DÒNG NÀY

import java.util.List;

public interface ProductOfferingsService {
    ProductOfferings getById(Long id);

    List<ProductOfferingRes> getAll();

    List<ProductOfferings> getByName(String name);

    List<ProductOfferings> getByNameAndColor(String name, String color);

    ProductOfferings createProduct(ProductOfferings productOfferings);

    ProductOfferings updateProduct(Long id, ProductOfferings productOfferings);

    List<ProductOfferings> getByDetailId(Long id);

    ProductOfferings createProductDto(CreateProductOfferingReq request);

    List<ProductOfferings> filter(String name, Long minPrice, Long maxPrice, String color, String status);

    List<ProductOfferings> filter1(ProductOfferingFilterReq productOfferingFilterReq);

    Page<ProductOfferings> getByPage(Integer pageSize, Integer pageNumber);
}
