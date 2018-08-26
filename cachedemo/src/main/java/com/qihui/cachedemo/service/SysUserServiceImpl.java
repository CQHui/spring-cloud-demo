package com.qihui.cachedemo.service;

import com.qihui.cachedemo.mapper.SysUserMapper;
import com.qihui.cachedemo.model.SysUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenqihui
 * @date 2018/8/5
 */
@Service
public class SysUserServiceImpl implements SysUserService{
    @Resource
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> getUsers() {
        return userMapper.selectAll();
    }

    @Override
    @Cacheable(value = "user", key = "'user_'+#userId")
    public SysUser getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @CachePut(value = "user", key="'user_'+#sysUser.id")
    public SysUser saveUser(SysUser sysUser) {
        userMapper.insertSelective(sysUser);
        return sysUser;
    }

    @Override
    @CachePut(value = "user", key="'user_'+#sysUser.id")
    public SysUser updateUser(SysUser sysUser) {
        userMapper.updateByPrimaryKeySelective(sysUser);
        return sysUser;
    }

    @Override
    @CacheEvict(value = "user", key="'user_'+#userId")
    public void deleteUser(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }
}
