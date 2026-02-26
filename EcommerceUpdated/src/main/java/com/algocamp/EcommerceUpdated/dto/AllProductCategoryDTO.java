package com.algocamp.EcommerceUpdated.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductCategoryDTO {
    private Long categoryId;
    private String name;
    private List<ProductDTO> products;
}
