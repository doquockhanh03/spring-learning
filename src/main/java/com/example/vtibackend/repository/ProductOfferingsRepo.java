package com.example.vtibackend.repository;

import com.example.vtibackend.entity.ProductOfferings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOfferingsRepo extends JpaRepository<ProductOfferings, Long> {

    List<ProductOfferings> findByName(String name);

    List<ProductOfferings> findByNameAndColor(String name, String color);

    @Query(value = "Select po from ProductOfferings po\n" +
            "where po.id in (select pod.productOfferings.id from ProductOfferingDetail pod where pod.productDetails.id = :id )")
    List<ProductOfferings> findByDetailId(Long id);
}
