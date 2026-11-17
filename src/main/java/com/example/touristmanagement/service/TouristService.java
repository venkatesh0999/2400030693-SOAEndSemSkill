package com.example.touristmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.touristmanagement.dto.TouristCreateRequest;
import com.example.touristmanagement.dto.TouristUpdateRequest;
import com.example.touristmanagement.entity.Tourist;
import com.example.touristmanagement.repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository repository;

    @Value("${app.security.request-token}")
    private String validToken;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public Tourist addTourist(TouristCreateRequest request) {
        Tourist tourist = new Tourist(
                request.getName(),
                request.getContactNumber(),
                request.getVisitedDestination()
        );
        return repository.save(tourist);
    }

    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }

    public Tourist getTourist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tourist not found"));
    }

    @Transactional
    public Tourist updateTourist(Long id, TouristUpdateRequest request, String token) {
        // Validate the custom token BEFORE reading or changing the record.
        if (token == null || !validToken.equals(token)) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Missing or invalid request token");
        }

        Tourist tourist = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tourist not found"));

        if (request.getContactNumber() != null) {
            tourist.setContactNumber(request.getContactNumber());
        }

        if (request.getVisitedDestination() != null) {
            tourist.setVisitedDestination(request.getVisitedDestination());
        }

        return repository.save(tourist);
    }
}
