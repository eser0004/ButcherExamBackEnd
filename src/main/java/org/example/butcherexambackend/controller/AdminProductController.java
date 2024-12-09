package org.example.butcherexambackend.controller;

import org.example.butcherexambackend.model.AdminProduct;
import org.example.butcherexambackend.service.AdminProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-products")
public class AdminProductController {
    private final AdminProductService adminProductService;

    public AdminProductController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }

    @GetMapping
    public ResponseEntity<List<AdminProduct>> getAllAdminProducts() {
        return ResponseEntity.ok(adminProductService.getAllAdminProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminProduct> getAdminProductById(@PathVariable int id) {
        return adminProductService.getAdminProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdminProduct> createAdminProduct(@RequestBody AdminProduct adminProduct) {
        return ResponseEntity.status(201).body(adminProductService.createAdminProduct(adminProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminProduct> updateAdminProduct(@PathVariable int id, @RequestBody AdminProduct adminProduct) {
        return ResponseEntity.ok(adminProductService.updateAdminProduct(id, adminProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdminProduct(@PathVariable int id) {
        adminProductService.deleteAdminProduct(id);
        return ResponseEntity.noContent().build();
    }
}
