package com.lifemanagement.reflect.dto;

import java.time.LocalDateTime;

public record TimeEntryResponseDTO(Long id, String description, LocalDateTime startTime, LocalDateTime endTime, Long categoryId) {
}
