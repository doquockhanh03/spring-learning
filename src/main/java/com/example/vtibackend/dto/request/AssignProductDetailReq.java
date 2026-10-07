package com.example.vtibackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssignProductDetailReq implements Serializable {
    private Long productOfferingIds;

    private List<Long> productDetailIds;
}
