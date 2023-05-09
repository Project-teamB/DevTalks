package com.teamproject.devTalks.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.teamproject.devTalks.entity.user.UserEntity;

public class UserPrinciple implements UserDetails{
    
    private UserEntity userEntity;

    public UserPrinciple(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return authorities;
        }

    @Override
    public String getPassword() {
        return userEntity.getUserPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;    
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  
    }

    @Override
    public boolean isCredentialsNonExpired() {    
        return true;  
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}