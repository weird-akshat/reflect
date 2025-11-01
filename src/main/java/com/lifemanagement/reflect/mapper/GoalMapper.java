package com.lifemanagement.reflect.mapper;

import com.lifemanagement.reflect.dto.GoalDto;
import com.lifemanagement.reflect.dto.GoalRequestDto;
import com.lifemanagement.reflect.entity.Goal;

import java.util.List;
import java.util.stream.Collectors;

public class GoalMapper {

    public static Goal toEntity(GoalRequestDto dto, Goal parentGoal, List<Goal> childGoals) {
        if (dto == null) {
            return null;
        }

        Goal goal = Goal.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .goalStatus(dto.getGoalStatus())
                .priority(dto.getPriority())
                .deadline(dto.getDeadline())
                .completedAt(dto.getCompletedAt())
                .build();


        if (dto.getParentGoalId() != null) {
            goal.setParentGoal(parentGoal);
        }

        if (dto.getChildGoalIds() != null) {
            goal.setChildGoals(childGoals);
        }

        return goal;
    }
    public static GoalDto toDto(Goal goal) {
        if (goal == null) {
            return null;
        }

        return GoalDto.builder()
                .id(goal.getId())
                .name(goal.getName())
                .description(goal.getDescription())
                .goalStatus(goal.getGoalStatus())
                .priority(goal.getPriority())
                .deadline(goal.getDeadline())
                .completedAt(goal.getCompletedAt())
                .parentGoalId(goal.getParentGoal() != null ? goal.getParentGoal().getId() : null)
                .childGoalIds(
                        goal.getChildGoals() != null
                                ? goal.getChildGoals().stream()
                                .map(Goal::getId)
                                .collect(Collectors.toList())
                                : null
                )
                .build();
    }
}
