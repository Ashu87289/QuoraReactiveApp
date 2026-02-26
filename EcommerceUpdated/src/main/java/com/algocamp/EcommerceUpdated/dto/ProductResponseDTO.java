package com.algocamp.EcommerceUpdated.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private ProductDTO product;
    private String message;
    private String status;
}
