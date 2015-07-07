package com.example.ulabsrg.prototype.domain.user;

/**
 * Created by ulabsrg on 07/07/2015.
 */
public class User {

    private String name;
    private String surname;
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
}
