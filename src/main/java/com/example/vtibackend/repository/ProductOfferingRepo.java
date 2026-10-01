package com.example.vtibackend.repository;

import com.example.vtibackend.entity.ProductOfferings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long> {

    List<ProductOfferings> findByName(String name);

    List<ProductOfferings> findByNameAndColor(String name, String color);
}
