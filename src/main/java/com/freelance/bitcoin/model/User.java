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
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku", "username"}),
    @UniqueConstraint(columnNames = {"sku", "username", "uniqueId"})
})
public class User implements Serializable{
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable =  false)
    private String uniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "username", columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String username;

    @Column(name = "password", columnDefinition = "varchar(256)", nullable = false)
    private String password;

    @Column(name = "fullname", columnDefinition = "varchar(70)", nullable = false)
    private String fullname;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean activated = false;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;
}
