package com.dilara.TryMe_App.service;

import com.dilara.TryMe_App.entity.CustomerAndProductImage;
import com.dilara.TryMe_App.repository.CustomerAndProductImageRepository;
import com.dilara.TryMe_App.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerAndProductImageService implements ICrudService<CustomerAndProductImage,Long> {
    private final CustomerAndProductImageRepository virtualTryOnImageRepository;

    @Override
    public CustomerAndProductImage save(CustomerAndProductImage virtualTryOnImage) {
        return virtualTryOnImageRepository.save(virtualTryOnImage);
    }

    @Override
    public CustomerAndProductImage update(CustomerAndProductImage virtualTryOnImage) {
        return virtualTryOnImageRepository.save(virtualTryOnImage);
    }

    @Override
    public Iterable<CustomerAndProductImage> saveAll(Iterable<CustomerAndProductImage> t) {
        return virtualTryOnImageRepository.saveAll(t);
    }

    @Override
    public CustomerAndProductImage deleteById(Long aLong) {
        return null;
    }

    @Override
    public Optional<CustomerAndProductImage> findById(Long aLong) {
        return virtualTryOnImageRepository.findById(aLong);
    }

    @Override
    public List<CustomerAndProductImage> findAll() {
        return virtualTryOnImageRepository.findAll();
    }
}
