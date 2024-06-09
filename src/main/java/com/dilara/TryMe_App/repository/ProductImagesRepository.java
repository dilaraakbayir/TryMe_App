package com.dilara.TryMe_App.repository;

import com.dilara.TryMe_App.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
    Optional<ProductImages> findByName(String fileName);

}
