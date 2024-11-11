package com.freelance.bitcoin.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ewallets")
public class EWallet implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable = false)
    private String uniqueId;

    @Column(name = "usdt", columnDefinition = "float", nullable = false)
    private double usdt = 0;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
