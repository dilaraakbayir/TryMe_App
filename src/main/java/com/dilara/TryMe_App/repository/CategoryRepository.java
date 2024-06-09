package com.dilara.TryMe_App.repository;

import com.dilara.TryMe_App.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
