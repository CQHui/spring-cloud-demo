package com.qihui.auth.dao;

import com.qihui.auth.model.AuthoritiesDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenqihui
 * @date 2018/7/2
 */
@Repository
public interface UserAuthorityMapper {
    List<AuthoritiesDO> getAllAuthority(Long userId);
}
