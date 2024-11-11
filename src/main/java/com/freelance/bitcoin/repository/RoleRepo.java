package com.freelance.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelance.bitcoin.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    
}
