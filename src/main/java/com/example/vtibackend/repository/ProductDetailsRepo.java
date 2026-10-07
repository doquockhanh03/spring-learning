package com.example.vtibackend.repository;

import com.example.vtibackend.entity.ProductDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDetailsRepo extends JpaRepository<ProductDetails, Long> {
}
