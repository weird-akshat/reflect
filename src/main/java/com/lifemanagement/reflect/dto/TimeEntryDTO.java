package com.lifemanagement.reflect.dto;

import java.time.LocalDateTime;

public record TimeEntryDTO(String description, LocalDateTime startTime, LocalDateTime endTime, Long categoryId) {


}
