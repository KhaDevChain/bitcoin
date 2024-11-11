package com.freelance.bitcoin.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomerWebConfig implements WebMvcConfigurer {
    @Value("${server.cms.port}")
    private String port_cms;

    @Value("${server.user.port}")
    private String port_user;

    @Override
    @SuppressWarnings("null")
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**") // chấp nhận toàn bộ mapping
            .allowedOrigins(
                String.format("http://localhost:%s", port_cms),
                String.format("http://localhost:%s", port_user)) // Chấp nhận dữ liệu dưới dạng http/https of URL
            .allowedMethods("*") // Chấp nhận tất cả dạng method get, post, put, delete
            .allowedHeaders("*"); // Chấp nhận dữ liệu lưu tại headers
    }
}
