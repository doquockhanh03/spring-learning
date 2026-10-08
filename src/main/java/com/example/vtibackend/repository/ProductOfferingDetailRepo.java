package com.example.vtibackend.repository;

import com.example.vtibackend.entity.ProductOfferingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOfferingDetailRepo extends JpaRepository<ProductOfferingDetail, Long> {
    List<ProductOfferingDetail> findByProductOfferingsId(Long productOfferingId);
}
