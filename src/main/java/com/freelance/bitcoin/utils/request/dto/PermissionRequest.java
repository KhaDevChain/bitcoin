package com.freelance.bitcoin.utils.request.dto;

import java.util.List;

import com.freelance.bitcoin.model.Permission;
import com.freelance.bitcoin.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRequest {
    private String groupName;
    private String groupPermission;
    private String description;
    private Boolean activated = false;
    private Long roleId;
    private Role role;
    private Permission permission;
    private List<Permission> permissions_;
}
