package com.example.touristmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tourists")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String contactNumber;

    private String visitedDestination;

    public Tourist() {
    }

    public Tourist(String name, String contactNumber, String visitedDestination) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.visitedDestination = visitedDestination;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getVisitedDestination() {
        return visitedDestination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setVisitedDestination(String visitedDestination) {
        this.visitedDestination = visitedDestination;
    }
}
