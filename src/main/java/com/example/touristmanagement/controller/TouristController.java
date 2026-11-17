package com.example.touristmanagement.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.touristmanagement.dto.TouristCreateRequest;
import com.example.touristmanagement.dto.TouristUpdateRequest;
import com.example.touristmanagement.entity.Tourist;
import com.example.touristmanagement.service.TouristService;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tourist> addTourist(@Valid @RequestBody TouristCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTourist(request));
    }

    @GetMapping
    public List<Tourist> getAllTourists() {
        return service.getAllTourists();
    }

    @GetMapping("/{id}")
    public Tourist getTourist(@PathVariable Long id) {
        return service.getTourist(id);
    }

    @PutMapping("/{id}")
    public Tourist updateTourist(
            @PathVariable Long id,
            @RequestHeader(value = "X-REQUEST-TOKEN", required = false) String token,
            @RequestBody TouristUpdateRequest request) {
        return service.updateTourist(id, request, token);
    }
}
