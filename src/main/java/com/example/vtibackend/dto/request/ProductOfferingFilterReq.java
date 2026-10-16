package com.example.vtibackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOfferingFilterReq {
    String name;
    Long minPrice;
    Long maxPrice;
    String color;
    String status;
}
