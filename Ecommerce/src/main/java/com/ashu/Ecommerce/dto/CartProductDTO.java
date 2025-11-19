package com.ashu.Ecommerce.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductDTO {
    private Integer productId;
    private Integer quantity;
}
