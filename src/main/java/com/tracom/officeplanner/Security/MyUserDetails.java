package com.tracom.officeplanner.Security;

import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private User user;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities ;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
        return user.isEnabled();
    }

    public String getFullName(){
        return this.user.getFirstname() + " " + this.user.getLastname();
    }

    public void setFirstname(String firstname) {
        this.user.setFirstname(firstname);
    }
    public void setLastname(String lastname) {
        this.user.setLastname(lastname);
    }

    public boolean hasRole(String name) {
        return user.hasRole(name);
    }

    public User getUser() {
        return this.user;
    }
}

