package com.lifemanagement.reflect.repository;

import com.lifemanagement.reflect.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
