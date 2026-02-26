package com.algocamp.EcommerceUpdated.mapper;

import com.algocamp.EcommerceUpdated.dto.ProductDTO;
import com.algocamp.EcommerceUpdated.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // DTO → Entity (Create)
    public Product toEntity(ProductDTO dto) {
        if (dto == null) return null;

        return Product.builder()

                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }

    // Entity → DTO (Response)
    public ProductDTO toDto(Product product) {
        if (product == null) return null;

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setImage(product.getImage());
        dto.setColor(product.getColor());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setDiscount(product.getDiscount());
        dto.setModel(product.getModel());
        dto.setTitle(product.getTitle());
        dto.setBrand(product.getBrand());
        dto.setPopular(product.isPopular());

        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
        }

        return dto;
    }
}
