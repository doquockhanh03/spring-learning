package com.example.vtibackend.Spec;

import com.example.vtibackend.entity.ProductOfferings;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

public class ProductOfferingSpec {
    public static Specification<ProductOfferings> likeName(String name){
        return new Specification<ProductOfferings>() {
            @Override
            public @Nullable Predicate toPredicate(Root<ProductOfferings> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if(name == null || name.isEmpty()){
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.equal(root.get("name"), "%" + name + "%");
            }
        };
    }
}
