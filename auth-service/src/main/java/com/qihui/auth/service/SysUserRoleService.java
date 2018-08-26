package com.qihui.auth.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author chenqihui
 * @date 2018/7/2
 */
public interface SysUserRoleService {
    Collection<? extends GrantedAuthority> getAllAuthorities(Long userId);
}
