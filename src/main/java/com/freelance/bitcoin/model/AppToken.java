package com.freelance.bitcoin.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(name = "apptokens", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username", "token"})
})
public class AppToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", columnDefinition = "varchar(256)", nullable = false)
    private String token;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

}
