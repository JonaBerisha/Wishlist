package com.example.wishlist.model;

import java.time.LocalDate;

public class User {
    private String name;
    private int id;
    private String email;
    private String password;
    private LocalDate birthDate;


    public User() {}

    public User(String name, int id, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
        this.birthDate = birthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
