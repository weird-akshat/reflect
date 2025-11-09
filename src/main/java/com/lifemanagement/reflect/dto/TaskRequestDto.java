package com.lifemanagement.reflect.dto;

import com.lifemanagement.reflect.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequestDto {

    private String title;
    private String description;

    private Priority priority;
    private Long categoryId;

    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private boolean completed;
}