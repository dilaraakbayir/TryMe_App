package com.dilara.TryMe_App.controller;

import com.dilara.TryMe_App.entity.Product;
import com.dilara.TryMe_App.service.ProductImagesService;
import com.dilara.TryMe_App.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.dilara.TryMe_App.constants.RestApi.PRODUCT;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;
    private final ProductImagesService productImagesService;

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public ResponseEntity<String> addProduct(@RequestBody Product product, @RequestParam("file") MultipartFile file) {
        try {
            productService.save(product);
            productImagesService.saveImage(file, product.getId());
            return ResponseEntity.ok(product.getName() +"--> Product added successfully.");
        } catch (IOException exception) {
            return ResponseEntity.badRequest().body("Error adding product.");
        }
    }

    @GetMapping("/find-all-by-brand-id")
    public ResponseEntity<List<Product>> findAllByBrandId(Long brandId){
        return ResponseEntity.ok(productService.findByAllBrandId(brandId));
    }

    @GetMapping("/find-all-by-model-id")
    public ResponseEntity<List<Product>> findAllByModelId(Long modelId){
        return ResponseEntity.ok(productService.findByAllModelId(modelId));
    }

    @GetMapping("/find-all-by-category-id")
    public ResponseEntity<List<Product>> findAllByCategoryId(Long categoryId){
        return ResponseEntity.ok(productService.findByAllCategoryId(categoryId));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

}
