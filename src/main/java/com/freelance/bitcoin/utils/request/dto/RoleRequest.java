package com.freelance.bitcoin.utils.request.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.freelance.bitcoin.model.Permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    private String roleName;
    private LocalDateTime createdAt;
    private List<Permission> permissions = new ArrayList<Permission>();
}
