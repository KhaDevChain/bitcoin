package com.freelance.bitcoin.utils.request.dto;

import com.freelance.bitcoin.model.Role;
import com.freelance.bitcoin.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String uniqueId;
    private String username;
    private String password;
    private String fullname;
    private String sku;
    private Boolean activated;
    private User user;
    private Role role;
    private Long roleId;
}
