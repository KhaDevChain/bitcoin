package com.freelance.bitcoin.security.jwt;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.freelance.bitcoin.security.detail.UserDetailServiceImpl;
import com.freelance.bitcoin.service.AppTokenService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private AppTokenService appTokenService;
    
    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);

            String username = jwtUtils.getUsernameFromToken(jwt);
            Date expiredDate = jwtUtils.getExpireDateFromToken(jwt);
            Claims claims = jwtUtils.getAllClaimsFromToken(jwt);
            
            log.info(">>>>>>>> USERNAME FROM TOKEN [Authorization] : " + username);
            log.info(">>>>>>>> EXPIREDATE FROM TOKEN [Authorization] : " + expiredDate);
            log.info(">>>>>>>> CLAIMS FROM TOKEN [Authorization] : \n" + claims + "\n");

            if (StringUtils.hasText(jwt) && jwtUtils.isTokenValid(jwt)) {
                UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(username);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, // principal
                        null,  // credentials
                        userDetails.getAuthorities() // authorities
                    );

                    // Nếu người dùng hợp lệ, set thông tin cho Seturity Context
                    authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            log.error("failed on set user authentication", e);
        }

        filterChain.doFilter(request, response);
    }
    
    protected String getJwtFromRequest(HttpServletRequest request) {
        // tại đây thay vì giữ token thì sẽ giữ username dùng để truy vấn đến
        String username_hide = request.getHeader("Authorization");
        if (StringUtils.hasText(username_hide) && username_hide.startsWith("Bearer ")) {
            String username = username_hide.substring(7);
            String token = appTokenService.getTokenByUsername(username).getToken();
            return token;
        }
        return null;
    }
}
