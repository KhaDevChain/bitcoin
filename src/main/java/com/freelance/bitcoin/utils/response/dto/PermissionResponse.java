package com.freelance.bitcoin.utils.response.dto;

import java.util.List;

import com.freelance.bitcoin.model.Permission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionResponse {
    private int status = 500;
    private String message = "";
    private Permission permission = null;
    private List<Permission> permissions_ = null;
}
