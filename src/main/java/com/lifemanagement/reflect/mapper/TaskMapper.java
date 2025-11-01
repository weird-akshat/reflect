package com.lifemanagement.reflect.mapper;

import com.lifemanagement.reflect.dto.TaskDto;
import com.lifemanagement.reflect.dto.TaskRequestDto;
import com.lifemanagement.reflect.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toEntity(TaskRequestDto taskRequestDto);
    TaskDto toDto(TaskDto taskDto);
}
