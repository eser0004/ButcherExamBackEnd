package org.example.butcherexambackend.repository;

import org.example.butcherexambackend.model.AdminProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductRepository extends JpaRepository<AdminProduct, Integer> {
}
