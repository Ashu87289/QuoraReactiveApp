package com.algocamp.EcommerceUpdated.services;

import com.algocamp.EcommerceUpdated.dto.CategoryDTO;
import com.algocamp.EcommerceUpdated.entity.Category;
import com.algocamp.EcommerceUpdated.repository.CategoryRepository;
import com.algocamp.EcommerceUpdated.service.serviceimpl.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)   //This annotation is use to enable Mockito for the test class with Junit
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    private CategoryDTO categoryDTO;
    private CategoryDTO categoryDTO1;
    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp(){
        categoryDTO = CategoryDTO.builder().name("Electronics").build();
        categoryDTO1 = CategoryDTO.builder().name("Books").build();
        category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);
    }

    @Test
    @DisplayName("Should return all categories successfully.")
    void getAllCategories_shouldReturnAllCategories(){
        //1st Step = Arrange
        List<Category> categories = new ArrayList<>();

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        //Mock the repository to return the cateories.
        when(categoryRepository.findAll()).thenReturn(categories);

        //2nd Step = Act
        //service is actually really called.
        List<CategoryDTO> res = categoryService.getAllCategories();

        //3rd Step = Assert
        assertEquals(3, res.size());
        verify(categoryRepository,times(1)).findAll();

    }


    @Test
    @DisplayName("Should create new Categories")
    void createCategory_shouldCreateAllCategories(){
        //Arrange
        when(categoryRepository.save(any(Category.class))).thenReturn(category1).thenReturn(category2);

        //Act (Execute Real Code)
        CategoryDTO result = categoryService.createCategory(categoryDTO);
        CategoryDTO result2 = categoryService.createCategory(categoryDTO1);

        //Assert
        assertEquals("Electronics",result.getName());
        assertEquals("Books",result2.getName());
    }

    @Test
    @DisplayName("Should return empty list when no categories exist")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoriesExist(){
        //Arrange
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());

        //Act
        List<CategoryDTO> result = categoryService.getAllCategories();

        //Assert
        assertEquals(result.size(),0);
        verify(categoryRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Should return category by name")
    void getByName_shouldReturnCategoryByName() {
        String categoryName = "Electronics";
        //Arrange
        when(categoryRepository.findByName(categoryName)).thenReturn(Optional.of(category1));

        //Act
        CategoryDTO result;
        try {
            result = categoryService.getByName(categoryName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertEquals(categoryName, result.getName());
        verify(categoryRepository,times(1)).findByName(categoryName);
    }
}
