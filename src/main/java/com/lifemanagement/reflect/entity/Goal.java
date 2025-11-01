package com.lifemanagement.reflect.entity;

import com.lifemanagement.reflect.enums.GoalStatus;
import com.lifemanagement.reflect.enums.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private GoalStatus goalStatus;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime deadline;
    private LocalDateTime completedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_goal_id")
    private Goal parentGoal;

    @OneToMany(mappedBy = "parentGoal", fetch = FetchType.LAZY)
    private List<Goal> childGoals;
}