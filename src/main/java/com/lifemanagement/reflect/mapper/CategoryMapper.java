package com.lifemanagement.reflect.mapper;

import com.lifemanagement.reflect.dto.CategoryDTO;
import com.lifemanagement.reflect.dto.CategoryResponseDTO;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.exception.MappingException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CategoryMapper {

    public static Category categoryDTOtoCategory(CategoryDTO categoryDTO){

        try{
            return  Category.builder().name(categoryDTO.name()).description(categoryDTO.description()).color(categoryDTO.color()).build();
        }
        catch (Exception e){
            log.error("Error in mapping category dto to entity");

            throw new MappingException("Mapping category DTO to entity exception",e);
        }

    }
    public static Category categoryDTOtoCategory(Long id,CategoryDTO categoryDTO){
        try{
            return  Category.builder().id(id).name(categoryDTO.name()).description(categoryDTO.description()).color(categoryDTO.color()).build();
        }
        catch (Exception e){
            log.error("Error in updating category dto to entity");

            throw new MappingException("Mapping category DTO to entity exception",e);
        }
    }
    public static CategoryResponseDTO categoryToResponseDTO(Category category){
        try{
            return new CategoryResponseDTO(category.getId(), category.getName(), category.getDescription(), category.getColor());
        }
        catch (Exception e){
            log.error("Error in mapping category entity to response dto");

            throw new MappingException("Mapping category entity to DTO exception",e);
        }

    }
}
