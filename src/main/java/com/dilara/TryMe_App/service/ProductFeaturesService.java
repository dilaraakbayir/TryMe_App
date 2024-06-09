package com.dilara.TryMe_App.service;

import com.dilara.TryMe_App.entity.ProductFeatures;
import com.dilara.TryMe_App.repository.ProductFeaturesRepository;
import com.dilara.TryMe_App.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductFeaturesService implements ICrudService<ProductFeatures, Long> {
    private final ProductFeaturesRepository productFeaturesRepository;


    @Override
    public ProductFeatures save(ProductFeatures productFeatures) {
        return productFeaturesRepository.save(productFeatures);
    }

    @Override
    public ProductFeatures update(ProductFeatures productFeatures) {
        return productFeaturesRepository.save(productFeatures);
    }

    @Override
    public Iterable<ProductFeatures> saveAll(Iterable<ProductFeatures> t) {
        return productFeaturesRepository.saveAll(t);
    }

    @Override
    public ProductFeatures deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<ProductFeatures> findById(Long aLong) {
        return productFeaturesRepository.findById(aLong);
    }

    @Override
    public List<ProductFeatures> findAll() {
        return productFeaturesRepository.findAll();
    }
}
