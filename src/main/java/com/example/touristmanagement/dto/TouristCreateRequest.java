package com.example.touristmanagement.dto;

import jakarta.validation.constraints.NotBlank;

public class TouristCreateRequest {

    @NotBlank
    private String name;

    private String contactNumber;

    private String visitedDestination;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getVisitedDestination() {
        return visitedDestination;
    }

    public void setVisitedDestination(String visitedDestination) {
        this.visitedDestination = visitedDestination;
    }
}
