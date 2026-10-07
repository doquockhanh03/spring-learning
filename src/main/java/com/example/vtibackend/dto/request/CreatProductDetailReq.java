package com.example.vtibackend.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreatProductDetailReq implements Serializable {
    Long weight;

    String feature;

    String power;

    String brand;

    String image;

    String video;
}
