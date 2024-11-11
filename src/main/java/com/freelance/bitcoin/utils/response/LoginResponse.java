package com.freelance.bitcoin.utils.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private int status;
    private String username;
    private String token;
    private String message;
}
