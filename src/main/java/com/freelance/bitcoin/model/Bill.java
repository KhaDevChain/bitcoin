package com.freelance.bitcoin.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "bills", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku", "content"})
})
public class Bill implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable =  false)
    private String uniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String sku;

    @Column(name = "content", columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String content;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "isConfirm", columnDefinition = "boolean")
    private Boolean isConfirm = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
