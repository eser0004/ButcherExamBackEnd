package org.example.butcherexambackend.service;

import org.example.butcherexambackend.model.AdminLogin;
import org.example.butcherexambackend.repository.AdminLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {

    private final AdminLoginRepository adminLoginRepository;

    @Autowired
    public AdminLoginService(AdminLoginRepository adminLoginRepository) {
        this.adminLoginRepository = adminLoginRepository;
    }

    // Method to validate the login credentials
    public boolean validateAdminLogin(String username, String password) {
        AdminLogin adminLogin = adminLoginRepository.findById(username).orElse(null);

        if (adminLogin != null && adminLogin.getPassword().equals(password)) {
            return true; // Login is successful
        }

        return false; // Invalid login credentials
    }
}
