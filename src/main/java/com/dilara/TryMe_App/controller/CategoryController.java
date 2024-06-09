package com.dilara.TryMe_App.controller;

import com.dilara.TryMe_App.entity.Category;
import com.dilara.TryMe_App.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> save(Category category){
        return ResponseEntity.ok(categoryService.save(category)); }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Category>> findById(Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
}
