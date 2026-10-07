package com.example.vtibackend.service.impl;

import com.example.vtibackend.common.Status;
import com.example.vtibackend.dto.request.CreateProductOfferingReq;
import com.example.vtibackend.entity.ProductOfferings;
import com.example.vtibackend.repository.ProductOfferingsRepo;
import com.example.vtibackend.service.ProductOfferingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOfferingsServiceImpl implements ProductOfferingsService {

    @Autowired
    private ProductOfferingsRepo productOfferingRepo;

    @Override
    public ProductOfferings getById(Long id) {
        Optional<ProductOfferings> product = productOfferingRepo.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("product is empty!");
        }
        return product.get();
    }

    @Override
    public List<ProductOfferings> getAll() {
        return productOfferingRepo.findAll();
    }

    @Override
    public List<ProductOfferings> getByName(String name) {
        List<ProductOfferings> product = productOfferingRepo.findByName(name);
        if(product.isEmpty()){
            throw new RuntimeException( name + " is not found!");
        }
        return product;
    }

    @Override
    public List<ProductOfferings> getByNameAndColor(String name, String color) {
        List<ProductOfferings> product = productOfferingRepo.findByNameAndColor(name, color);
        if(product.isEmpty()){
            throw new RuntimeException("Data not found!");
        }
        return product;
    }

    @Override
    public ProductOfferings createProduct(ProductOfferings productOfferings) {
        if(productOfferings.getId() != null){
            throw new RuntimeException("Khong duoc truyen id vao!");
        }
        return productOfferingRepo.save(productOfferings);
    }

    @Override
    public ProductOfferings updateProduct(Long id, ProductOfferings productOfferings) {
            Optional<ProductOfferings> productExist = productOfferingRepo.findById(id);
            if (productExist.isEmpty()) {
                throw new RuntimeException("Khong ton tai id can sua");
            }
            productOfferings.setId(id);
        return productOfferingRepo.save(productOfferings);
    }

    @Override
    public List<ProductOfferings> getByDetailId(Long id) {
        return productOfferingRepo.findByDetailId(id);
    }

    @Override
    public ProductOfferings createProductDto(CreateProductOfferingReq request) {
        if(request.getName().isEmpty() || request.getColor().isEmpty() || request.getPrice() == null){
            throw new RuntimeException("Khong duoc de trong du lieu!");
        }

        ProductOfferings productOfferings = new ProductOfferings();

        productOfferings.setName(request.getName());
        productOfferings.setColor(request.getColor());
        productOfferings.setPrice(request.getPrice());
        productOfferings.setStatus(Status.ACTIVE);

        return productOfferingRepo.save(productOfferings);
    }


}
