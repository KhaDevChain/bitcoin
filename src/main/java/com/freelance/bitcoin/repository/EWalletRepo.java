package com.freelance.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelance.bitcoin.model.EWallet;

@Repository
public interface EWalletRepo extends JpaRepository<EWallet, String> {

}
