package com.qihui.cachedemo.api;

import com.qihui.cachedemo.mapper.SysUserMapper;
import com.qihui.cachedemo.model.SysUser;
import com.qihui.cachedemo.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenqihui
 * @date 2018/8/5
 */
@RestController
@RequestMapping("/api/user")
public class SysUserApi {

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/all")
    public List<SysUser> getUsers() {
        return userMapper.selectAll();
    }

    @GetMapping("/{userId}")
    public SysUser getUser(@PathVariable Long userId) {
        return sysUserService.getUserById(userId);

    }

    @PostMapping
    public void saveUser(@RequestBody SysUser sysUser) {
        sysUserService.saveUser(sysUser);
    }

    @PutMapping
    public void updateUser(@RequestBody SysUser sysUser) {
        sysUserService.updateUser(sysUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        sysUserService.deleteUser(userId);
    }

}
