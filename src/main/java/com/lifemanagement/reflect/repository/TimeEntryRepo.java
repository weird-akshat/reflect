package com.lifemanagement.reflect.repository;

import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface TimeEntryRepo extends JpaRepository<TimeEntry,Long> {
    List<TimeEntry> findByUserId(Long id);
    List<TimeEntry> findByCategory(Category category);

}
