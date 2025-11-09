package com.lifemanagement.reflect.repository;

import com.lifemanagement.reflect.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepo extends JpaRepository<Goal,Long> {
}
