package com.lifemanagement.reflect.controller;

import com.lifemanagement.reflect.dto.CategoryDTO;
import com.lifemanagement.reflect.dto.CategoryResponseDTO;
import com.lifemanagement.reflect.mapper.CategoryMapper;
import com.lifemanagement.reflect.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable long id, @RequestBody CategoryDTO categoryDTO){
        try {
            return new ResponseEntity<>(categoryService.saveCategory(id,categoryDTO), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable long id){
        try{

            categoryService.deleteCategory(id);



            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
