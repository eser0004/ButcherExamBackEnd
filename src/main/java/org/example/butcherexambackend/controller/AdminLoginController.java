package org.example.butcherexambackend.controller;

import org.example.butcherexambackend.model.AdminLogin;
import org.example.butcherexambackend.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    private final AdminLoginService adminLoginService;

    @Autowired
    public AdminLoginController(AdminLoginService adminLoginService) {
        this.adminLoginService = adminLoginService;
    }

    // POST endpoint for login

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody AdminLogin loginRequest) {
        boolean isValid = adminLoginService.validateAdminLogin(loginRequest.getUsername(), loginRequest.getPassword());

        if (isValid) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
