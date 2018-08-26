package com.qihui.cachedemo.service;

import com.qihui.cachedemo.model.SysUser;

import java.util.List;

/**
 * @author chenqihui
 * @date 2018/8/5
 */
public interface SysUserService {
    List<SysUser> getUsers();

    SysUser getUserById(Long userId);

    SysUser saveUser(SysUser sysUser);

    SysUser updateUser(SysUser sysUser);

    void deleteUser(Long userId);
}
