package com.bridgelabz.greetingApp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;

    public Greeting() {}

    public Greeting(String message) {
        this.message = message;
    }

    public Greeting(long l, String message) {
        this.id = l;
        this.message = message;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getMessage() { return message; }
    public void setId(Long id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }

}
