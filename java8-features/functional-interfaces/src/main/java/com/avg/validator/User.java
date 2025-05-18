package com.avg.validator;

public class User {
    private String email;
    private String password;

    // Constructor, Getters and Setters
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}