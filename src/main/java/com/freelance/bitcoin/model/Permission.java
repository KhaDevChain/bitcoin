package com.freelance.bitcoin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "permissions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"groupName", "groupPermission"}),
    @UniqueConstraint(columnNames = {"uniqueId", "groupName", "groupPermission"})
})
@Data
public class Permission implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)", nullable = false)
    private String uniqueId;

    @Column(name = "groupName", columnDefinition = "varchar(20)", nullable = false, unique = true)
    private String groupName;

    @Column(name = "groupPermission", columnDefinition = "varchar(300)", nullable = false)
    private String groupPermission;

    @Column(name = "description", columnDefinition = "varchar(20)")
    private String description;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "activated", columnDefinition = "boolean")
    private Boolean activated = false;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
