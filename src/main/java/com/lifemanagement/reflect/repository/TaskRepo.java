package com.lifemanagement.reflect.repository;

import com.lifemanagement.reflect.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Long> {
}
