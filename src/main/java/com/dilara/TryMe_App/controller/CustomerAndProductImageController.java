package com.dilara.TryMe_App.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-product-images")
public class CustomerAndProductImageController {
    private final CloudinaryService cloudinaryService;

    @PostMapping(value = "/try-product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> tryProduct(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadFile(file);
            return ResponseEntity.ok("Virtual try on successfully. URL: " + imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image.");
        }
    }
}
