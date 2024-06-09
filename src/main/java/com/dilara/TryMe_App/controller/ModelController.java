package com.dilara.TryMe_App.controller;

import com.dilara.TryMe_App.entity.Model;
import com.dilara.TryMe_App.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Model>> findAll(){
        List<Model> modelList = modelService.findAll();
        if(modelList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(modelList);
    }

    @PostMapping("/add")
    public ResponseEntity<Model> save(@RequestBody Model model){
        return ResponseEntity.ok(modelService.save(model));
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Model>> findById(@PathVariable Long id){
        return ResponseEntity.ok(modelService.findById(id));
    }
}
