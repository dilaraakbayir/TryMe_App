package com.dilara.TryMe_App.service;

import com.dilara.TryMe_App.entity.Brand;
import com.dilara.TryMe_App.repository.BrandRepository;
import com.dilara.TryMe_App.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BrandService implements ICrudService<Brand,Long> {
    private final BrandRepository brandRepository;

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Iterable<Brand> saveAll(Iterable<Brand> t) {
        return brandRepository.saveAll(t);
    }

    @Override
    public Brand deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Brand> findById(Long aLong) {
        return brandRepository.findById(aLong);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
