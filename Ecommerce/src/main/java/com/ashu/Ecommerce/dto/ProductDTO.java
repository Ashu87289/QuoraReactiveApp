package com.ashu.Ecommerce.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO{
	private int id;
	private String title;
	private Object price;
	private String description;
	private String category;
	private String image;
}