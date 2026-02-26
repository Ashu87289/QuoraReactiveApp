package com.algocamp.EcommerceUpdated.service;


import com.algocamp.EcommerceUpdated.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    CategoryDTO createCategory(CategoryDTO dto);

    CategoryDTO getCategoryById(Long id);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getByName(String name) throws Exception;

}
