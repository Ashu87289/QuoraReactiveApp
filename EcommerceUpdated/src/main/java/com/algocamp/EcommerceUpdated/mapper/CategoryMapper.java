package com.algocamp.EcommerceUpdated.mapper;

import com.algocamp.EcommerceUpdated.dto.CategoryDTO;
import com.algocamp.EcommerceUpdated.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category entity){
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }
}
