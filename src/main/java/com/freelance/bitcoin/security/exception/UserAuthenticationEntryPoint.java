package com.freelance.bitcoin.security.exception;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        Integer statusCode = response.getStatus();

        if (statusCode == 400) {
            response.sendRedirect("/error/400");
        } 
        else if (statusCode == 404) {
            response.sendRedirect("/error/404");
        } 
        else if (statusCode == 403) {
            response.sendRedirect("/error/403");
        } 
        else if (statusCode == 500) {
            response.sendRedirect("/error/500");
        } 
        else if (statusCode == 401){
            response.sendRedirect("/login");
        }
        else {
            // mặc định 500
            response.sendRedirect("/error/404");
        }
    }
}
