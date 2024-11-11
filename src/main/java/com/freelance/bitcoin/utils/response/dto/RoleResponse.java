package com.freelance.bitcoin.utils.response.dto;

import java.util.List;

import com.freelance.bitcoin.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    // default value
    private int status = 500;
    private String message = "";
    private Role role = null;
    private List<Role> roles = null;
}
