package com.freelance.bitcoin.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uniqueId;

    @Column(name = "roleName", columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String roleName;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime createdAt = LocalDateTime.now();

    // role cập nhật thì các permistion cũng sẽ tự cập nhật
    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Permission> permissions;
}
