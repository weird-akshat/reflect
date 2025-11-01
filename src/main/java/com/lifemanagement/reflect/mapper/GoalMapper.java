package com.lifemanagement.reflect.mapper;

import com.lifemanagement.reflect.dto.GoalDto;
import com.lifemanagement.reflect.dto.GoalRequestDto;
import com.lifemanagement.reflect.entity.Goal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoalMapper {
    Goal toEntity(GoalRequestDto goalDto);
    GoalDto toDto(Goal goal);
}
