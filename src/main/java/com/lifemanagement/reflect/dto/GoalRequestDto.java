package com.lifemanagement.reflect.dto;

import com.lifemanagement.reflect.enums.GoalStatus;
import com.lifemanagement.reflect.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoalRequestDto {
    private String name;
    private String description;

    private GoalStatus goalStatus;
    private Priority priority;

    private LocalDateTime deadline;
    private LocalDateTime completedAt;


    private Long parentGoalId;


    private List<Long> childGoalIds;
}
