package com.dilara.TryMe_App.repository;

import com.dilara.TryMe_App.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
