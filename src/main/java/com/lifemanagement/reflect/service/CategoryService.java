package com.lifemanagement.reflect.service;

import com.lifemanagement.reflect.dto.CategoryDTO;
import com.lifemanagement.reflect.dto.CategoryResponseDTO;
import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.mapper.CategoryMapper;
import com.lifemanagement.reflect.mapper.TimeEntryMapper;
import com.lifemanagement.reflect.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryResponseDTO saveCategory(CategoryDTO categoryDTO){
        try{
            Category category = CategoryMapper.categoryDTOtoCategory(categoryDTO);

            categoryRepo.save(category);

            return CategoryMapper.categoryToResponseDTO(category);
        }
        catch (Exception e){
            throw new RuntimeException("Exception in saving category ",e);
        }
    }
    public CategoryResponseDTO saveCategory(Long id, CategoryDTO categoryDTO){
        try{
            Category category = CategoryMapper.categoryDTOtoCategory(id,categoryDTO);

            categoryRepo.save(category);

            return CategoryMapper.categoryToResponseDTO(category);
        }
        catch (Exception e){
            throw new RuntimeException("Exception in saving category ",e);
        }
    }


}
