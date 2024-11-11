package com.freelance.bitcoin.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.freelance.bitcoin.security.detail.UserDetailServiceImpl;
import com.freelance.bitcoin.security.exception.UserAuthenticationEntryPoint;
import com.freelance.bitcoin.security.jwt.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Autowired
    protected UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    protected JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    protected PBKDF2PasswordEncoder pbkdf2PasswordEncoder;

    @Autowired
    protected UserAuthenticationEntryPoint authenticationEntryPoint;

    // cấp quyền cho các controller có thể sử dụng
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // cấp quyền filter xác nhận token cho các domain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.disable())
            .sessionManagement(session -> session.disable())
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(formLogin -> formLogin.disable())
            .csrf(csrf -> csrf.disable())
            .logout(logout -> logout.disable());
        
        http
            .exceptionHandling(exception -> 
                exception.authenticationEntryPoint(authenticationEntryPoint))
            .authorizeHttpRequests(author ->
                author.requestMatchers(
                        // chặn các API không cần authorization
                            "/api2/v2/login",
                            "/api2/v2/signup",

                        // chặn các page không cần authorization
                            "/login",
                            "/signup",
                            "/auth/login",
                            "/error/**").permitAll()

                      .anyRequest().authenticated());
                
        http
            .addFilterBefore(jwtAuthenticationFilter, 
                             UsernamePasswordAuthenticationFilter.class);
        
        return http.build();

    }
}
