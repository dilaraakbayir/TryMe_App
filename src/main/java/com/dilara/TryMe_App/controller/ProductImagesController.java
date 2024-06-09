package com.dilara.TryMe_App.controller;

import com.dilara.TryMe_App.entity.ProductImages;
import com.dilara.TryMe_App.service.CloudinaryService;
import com.dilara.TryMe_App.service.ProductImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/product-images")
public class ProductImagesController {
    private final ProductImagesService productImagesService;
    private final CloudinaryService cloudinaryService;


    @PostMapping(value = "/add-product-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> addImages(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinaryService.uploadFile(file);
            productImagesService.save(ProductImages.builder()
                    .image(imageUrl)
                    .build());
            return ResponseEntity.ok("Image uploaded successfully. URL: " + imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading image.");
        }
    }


}
