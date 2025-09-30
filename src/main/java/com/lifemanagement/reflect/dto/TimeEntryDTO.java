package com.lifemanagement.reflect.dto;

import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;

import java.time.LocalDateTime;

public record TimeEntryDTO(String description, LocalDateTime startTime, LocalDateTime endTime, Long categoryId) {


}
