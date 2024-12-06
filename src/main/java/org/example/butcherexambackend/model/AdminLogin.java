package org.example.butcherexambackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_login")
public class AdminLogin {

    @Id
    @Column(nullable = false, unique = true)
    private String username; // Acts as the primary key

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    // Constructors
    public AdminLogin() {
    }

    public AdminLogin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}