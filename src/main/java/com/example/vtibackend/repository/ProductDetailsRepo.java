package com.example.vtibackend.repository;

import com.example.vtibackend.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepo extends JpaRepository<ProductDetails, Long> {
}
