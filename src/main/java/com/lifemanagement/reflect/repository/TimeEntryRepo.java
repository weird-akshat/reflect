package com.lifemanagement.reflect.repository;

import com.lifemanagement.reflect.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeEntryRepo extends JpaRepository<TimeEntry,Long> {
}
