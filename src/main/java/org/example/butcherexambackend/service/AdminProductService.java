package org.example.butcherexambackend.service;

import org.example.butcherexambackend.model.AdminProduct;
import org.example.butcherexambackend.repository.AdminProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminProductService {
    private final AdminProductRepository adminProductRepository;

    public AdminProductService(AdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }

    public List<AdminProduct> getAllAdminProducts() {
        return adminProductRepository.findAll();
    }

    public Optional<AdminProduct> getAdminProductById(int id) {
        return adminProductRepository.findById(id);
    }

    public AdminProduct createAdminProduct(AdminProduct adminProduct) {
        return adminProductRepository.save(adminProduct);
    }

    public AdminProduct updateAdminProduct(int id, AdminProduct adminProductDetails) {
        return adminProductRepository.findById(id).map(adminProduct -> {
            adminProduct.setName(adminProductDetails.getName());
            adminProduct.setDescription(adminProductDetails.getDescription());
            adminProduct.setPrice(adminProductDetails.getPrice());
            adminProduct.setWeight(adminProductDetails.getWeight());
            adminProduct.setQuantity(adminProductDetails.getQuantity());
            adminProduct.setImageUrl(adminProductDetails.getImageUrl());
            return adminProductRepository.save(adminProduct);
        }).orElseThrow(() -> new RuntimeException("AdminProduct not found"));
    }

    public void deleteAdminProduct(int id) {
        adminProductRepository.deleteById(id);
    }
}
