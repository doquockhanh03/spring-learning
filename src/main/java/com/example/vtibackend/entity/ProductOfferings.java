package com.example.vtibackend.entity;

import com.example.vtibackend.common.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product_offerings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOfferings implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "color")
    private String color;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "productOfferings")
    private List<ProductOfferingDetail> productOfferingDetails;


//    @OneToOne(fetch = FetchType.LAZY)

//    @ManyToOne
//    @JoinColumn(name = "detail_id", referencedColumnName = "id")
//    @JsonIgnore
//    private ProductDetails productDetails;
}
