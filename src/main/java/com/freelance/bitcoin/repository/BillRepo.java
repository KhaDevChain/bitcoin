package com.freelance.bitcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelance.bitcoin.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, String>{

}
