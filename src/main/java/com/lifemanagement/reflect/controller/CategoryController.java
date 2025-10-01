package com.lifemanagement.reflect.controller;

import com.lifemanagement.reflect.dto.CategoryDTO;
import com.lifemanagement.reflect.dto.CategoryResponseDTO;
import com.lifemanagement.reflect.mapper.CategoryMapper;
import com.lifemanagement.reflect.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        try {
            return new ResponseEntity<>(categoryService.saveCategory(categoryDTO), HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new RuntimeException("Error in creating category",e);
        }
    }
}
