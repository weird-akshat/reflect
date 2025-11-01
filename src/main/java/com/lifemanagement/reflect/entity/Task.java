package com.lifemanagement.reflect.entity;

import com.lifemanagement.reflect.enums.Priority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Priority priority;
    @OneToOne
    @JoinColumn(name = "activity_id")
    private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private boolean completed;


}