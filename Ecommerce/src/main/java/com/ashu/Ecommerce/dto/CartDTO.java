package com.ashu.Ecommerce.dto;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {
    private Integer id;
    private Integer userId;
    private String date;
    private List<CartProductDTO> products;
    private Integer __v;
}
