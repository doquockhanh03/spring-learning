package com.example.vtibackend.repository;

import com.example.vtibackend.entity.ProductOfferings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOfferingRepo extends JpaRepository<ProductOfferings, Long> {
}
