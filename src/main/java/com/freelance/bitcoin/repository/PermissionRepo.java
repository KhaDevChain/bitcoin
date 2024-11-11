package com.freelance.bitcoin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freelance.bitcoin.model.Permission;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, String> {
    @Query("SELECT o FROM Permission o WHERE o.groupName=:groupName")
    Optional<Permission> findByGroupName(String groupName);
}
