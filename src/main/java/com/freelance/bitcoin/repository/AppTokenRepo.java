package com.freelance.bitcoin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freelance.bitcoin.model.AppToken;

@Repository
public interface AppTokenRepo extends JpaRepository<AppToken, Long> {
    @Query("SELECT o FROM AppToken o WHERE o.username=:username")
    Optional<AppToken> findTokenByUsername(String username);
}
