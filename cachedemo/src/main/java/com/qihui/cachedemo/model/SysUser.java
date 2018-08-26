package com.qihui.cachedemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author chenqihui
 * @date 2018/8/5
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -7357983568966973518L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String mobile;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;


}
