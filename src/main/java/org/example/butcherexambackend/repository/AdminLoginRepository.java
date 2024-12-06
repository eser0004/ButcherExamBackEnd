package org.example.butcherexambackend.repository;

import org.example.butcherexambackend.model.AdminLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, String> {

}
