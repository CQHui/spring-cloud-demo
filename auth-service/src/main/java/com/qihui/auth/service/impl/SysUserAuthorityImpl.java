package com.qihui.auth.service.impl;

import com.qihui.auth.dao.UserAuthorityMapper;
import com.qihui.auth.model.AuthoritiesDO;
import com.qihui.auth.service.SysUserRoleService;
import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author chenqihui
 * @date 2018/7/2
 */
@Service
public class SysUserAuthorityImpl implements SysUserRoleService {
    @Resource
    private UserAuthorityMapper userAuthorityMapper;
    @Override
    public Collection<? extends GrantedAuthority> getAllAuthorities(Long userId) {
        List<AuthoritiesDO> allAuthority = userAuthorityMapper.getAllAuthority(userId);
        List<GrantedAuthority> authList = Lists.newArrayList();
        for (AuthoritiesDO authoritie : allAuthority) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authoritie.getMenuCode());
            authList.add(grantedAuthority);
        }
        return authList;
    }
}
