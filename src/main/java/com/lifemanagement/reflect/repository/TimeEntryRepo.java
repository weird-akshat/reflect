package com.lifemanagement.reflect.repository;

import com.lifemanagement.reflect.entity.AppUser;
import com.lifemanagement.reflect.entity.Category;
import com.lifemanagement.reflect.entity.TimeEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TimeEntryRepo extends JpaRepository<TimeEntry,Long> {
    List<TimeEntry> findByUserId(Long id);
    List<TimeEntry> findByCategory(Category category);
    Page<TimeEntry> findByUser(AppUser user, Pageable pageable);

}
