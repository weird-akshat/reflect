package com.lifemanagement.reflect.mapper;

import com.lifemanagement.reflect.dto.TaskDto;
import com.lifemanagement.reflect.entity.Task;

import com.lifemanagement.reflect.dto.TaskRequestDto;
import com.lifemanagement.reflect.entity.Category;


public class TaskMapper {

    public static Task toEntity(TaskRequestDto dto, Category category) {
        if (dto == null) {
            return null;
        }

        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(dto.getPriority())
                .category(category)
                .createdAt(dto.getCreatedAt())
                .dueDate(dto.getDueDate())
                .completed(dto.isCompleted())
                .build();
    }
    public static Task toEntity(TaskDto dto, Category category) {
        if (dto == null) {
            return null;
        }

        return Task.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(dto.getPriority())
                .category(category)
                .createdAt(dto.getCreatedAt())
                .dueDate(dto.getDueDate())
                .completed(dto.isCompleted())
                .build();
    }

    public static TaskDto toDto(Task task) {
        if (task == null) {
            return null;
        }

        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .priority(task.getPriority())
                .categoryId(task.getCategory() != null ? task.getCategory().getId() : null)
                .createdAt(task.getCreatedAt())
                .dueDate(task.getDueDate())
                .completed(task.isCompleted())
                .build();
    }
}
