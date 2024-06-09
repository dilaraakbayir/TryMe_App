package com.dilara.TryMe_App.controller;

import com.dilara.TryMe_App.entity.Brand;
import com.dilara.TryMe_App.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;

    @PostMapping("/add")
    public ResponseEntity<Brand> save(@RequestBody Brand brand){
        return ResponseEntity.ok(brandService.save(brand));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Brand>> findAll(){
        return ResponseEntity.ok(brandService.findAll());
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Brand>> findById(Long id){
        return ResponseEntity.ok(brandService.findById(id));
    }
}
