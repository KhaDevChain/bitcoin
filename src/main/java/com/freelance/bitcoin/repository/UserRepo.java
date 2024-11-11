package com.freelance.bitcoin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freelance.bitcoin.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Query("SELECT o FROM User o WHERE o.username=:username")
    Optional<User> findByUsername(String username);

    @Query("SELECT o FROM User o WHERE o.SKU=:sku")
    Optional<User> findBySKU(String sku);

    @Query("SELECT o FROM User o WHERE o.fullname LIKE %:character%")
    List<User> findByFullnameLike(String character);

    @Query("SELECT o FROM User o WHERE o.activated=True")
    List<User> findAllActivated();

    @Query("SELECT o FROM User o WHERE o.activated=True")
    Page<User> findAllActivated(Pageable pageable);
}
