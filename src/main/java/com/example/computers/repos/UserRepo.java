package com.example.computers.repos;

import com.example.computers.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    
    Users findByActivationCode(String code);
    
    Users findByEmail(String email);
}
