package com.dilara.TryMe_App.service;

import com.dilara.TryMe_App.entity.Model;
import com.dilara.TryMe_App.repository.ModelRepository;
import com.dilara.TryMe_App.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ModelService  implements ICrudService<Model, Long> {
    private final ModelRepository modelRepository;
    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model update(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Iterable<Model> saveAll(Iterable<Model> t) {
        return modelRepository.saveAll(t);
    }

    @Override
    public Model deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<Model> findById(Long aLong) {
        return modelRepository.findById(aLong);
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }
}
