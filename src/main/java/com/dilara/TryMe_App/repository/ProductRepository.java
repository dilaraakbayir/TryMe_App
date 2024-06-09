package com.dilara.TryMe_App.repository;

import com.dilara.TryMe_App.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrandId(Long brandId);

    List<Product> findAllByModelId(Long modelId);

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findAllByPriceBetween(Double min, Double max);

}
