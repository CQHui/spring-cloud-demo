package com.qihui.cachedemo.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author chenqihui
 * @date 2018/8/5
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
