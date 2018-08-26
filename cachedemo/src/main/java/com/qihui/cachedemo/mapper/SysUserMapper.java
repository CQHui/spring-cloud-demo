package com.qihui.cachedemo.mapper;

import com.qihui.cachedemo.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenqihui
 * @date 2018/8/5
 */
@Mapper
public interface SysUserMapper extends MyMapper<SysUser>  {
}
