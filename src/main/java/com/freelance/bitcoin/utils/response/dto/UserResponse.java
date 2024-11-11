package com.freelance.bitcoin.utils.response.dto;

import java.util.List;

import com.freelance.bitcoin.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int status = 500;
    private String message = "";
    private User user = null;
    private List<User> users_ = null;
}
