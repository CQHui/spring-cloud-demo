package com.qihui.auth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author chenqihui
 * @date 2018/7/1
 */
public class JWTUserDetail implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;

    public JWTUserDetail(Long id, String username, String password, boolean enabled) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public JWTUserDetail(Long id, String username, String password, boolean enabled,
                         Collection<? extends GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return enabled;
    }

    @Override
    public String toString() {
        return "MyUserDetails [id=" + id + ", username=" + username
                + ", password=" + password + ", enabled=" + enabled
                + ", authorities=" + authorities + "]";
    }

}
