package com.freelance.bitcoin.security.detail;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.freelance.bitcoin.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return user.getRoles().stream().map(
        //     author -> new SimpleGrantedAuthority(author.getRoleName())
        // ).collect(Collectors.toList());
        return Collections.singletonList(
            new SimpleGrantedAuthority(user.getRole().getRoleName())
        );
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return user.isActivated();
    }

    public String getSKU() {
        return user.getSKU();
    }
}
