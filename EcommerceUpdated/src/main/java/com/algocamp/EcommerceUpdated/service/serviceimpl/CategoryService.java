package com.algocamp.EcommerceUpdated.service.serviceimpl;

import com.algocamp.EcommerceUpdated.dto.CategoryDTO;
import com.algocamp.EcommerceUpdated.entity.Category;
import com.algocamp.EcommerceUpdated.mapper.CategoryMapper;
import com.algocamp.EcommerceUpdated.repository.CategoryRepository;
import com.algocamp.EcommerceUpdated.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {

        //Converting dto into entity using CategorMapper.
        Category category = CategoryMapper.toEntity(dto);
        //Now save the data into database by using constructor injection
        Category saved = categoryRepository.save(category);
        //Converting saved Entity back to DTO and returning.
        return CategoryMapper.toDTO(saved);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        //orElseThrow only works with Optional.
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Category is not found with this : " + id));
        return CategoryMapper.toDTO(category);
    }

    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> categoryDTO = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            categoryDTO.add(CategoryMapper.toDTO(category));
        }
        return categoryDTO;
    }

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Category not Found for this name."));

        return CategoryMapper.toDTO(category);
    }
}
