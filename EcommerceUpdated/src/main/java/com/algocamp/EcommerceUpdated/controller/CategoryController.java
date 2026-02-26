package com.algocamp.EcommerceUpdated.controller;

import com.algocamp.EcommerceUpdated.dto.CategoryDTO;
import com.algocamp.EcommerceUpdated.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
        return ResponseEntity.ok(categoryService.createCategory(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryByid(@PathVariable Long id){
        CategoryDTO dto = this.categoryService.getCategoryById(id);
        return ResponseEntity.ok(dto);
    }

    /*@GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){

    }*/

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()) {
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }else {
            List<CategoryDTO> result = this.categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }
}
