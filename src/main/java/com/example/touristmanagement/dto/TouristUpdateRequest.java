package com.example.touristmanagement.dto;

public class TouristUpdateRequest {

    private String contactNumber;

    private String visitedDestination;

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
