package com.qihui.auth.dao;

import com.qihui.auth.model.SysUserDO;
import org.springframework.stereotype.Repository;

/**
 * @author chenqihui
 * @date 2018/7/1
 */
@Repository
public interface UserMapper {
    SysUserDO getUserByUsername(String loginName);
}
