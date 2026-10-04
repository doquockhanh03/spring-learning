package com.example.vtibackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "weight")
    Long weight;

    @Column(name = "feature")
    String feature;

    @Column(name = "power")
    String power;

    @Column(name = "brand")
    String brand;

    @Column(name = "image")
    String image;

    @Column(name = "video")
    String video;
}
