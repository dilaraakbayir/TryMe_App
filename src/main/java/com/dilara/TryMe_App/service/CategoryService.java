package com.dilara.TryMe_App.service;

import com.dilara.TryMe_App.entity.Category;
import com.dilara.TryMe_App.repository.CategoryRepository;
import com.dilara.TryMe_App.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICrudService<Category,Long> {
    private final CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Iterable<Category> saveAll(Iterable<Category> t) {
        return categoryRepository.saveAll(t);
    }

    @Override
    public Category deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return categoryRepository.findById(aLong);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
