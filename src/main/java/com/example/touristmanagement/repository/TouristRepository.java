package com.example.touristmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.touristmanagement.entity.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
