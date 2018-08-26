package com.qihui.auth.service.impl;

import com.qihui.auth.dao.UserMapper;
import com.qihui.auth.model.JWTUserDetail;
import com.qihui.auth.model.SysUserDO;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author chenqihui
 * @date 2018/7/1
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    SysUserAuthorityImpl sysUserAuthority;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserDO user = userMapper.getUserByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("用户名不存在或者密码错误");
        }
        Collection<? extends GrantedAuthority> authorities = sysUserAuthority.getAllAuthorities(user.getId());
        return new JWTUserDetail(user.getId(), user.getUsername(), user.getPassword(), true, authorities);
    }
}
