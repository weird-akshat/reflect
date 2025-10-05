package com.lifemanagement.reflect.dto;

import com.lifemanagement.reflect.entity.Category;

import java.time.LocalDateTime;


public record TimeEntryResponseDTO(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, Long categoryId) {

    public TimeEntryResponseDTO(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, Category category){
        this(
                id,
                description,
                startTime,
                endTime,
                category != null ? category.getId() : null
        );

    }
}
