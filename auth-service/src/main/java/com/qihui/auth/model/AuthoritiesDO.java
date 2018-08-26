package com.qihui.auth.model;

/**
 * @author chenqihui
 * @date 2018/7/1
 */
public class AuthoritiesDO {
    private Long id;
    private String menuCode;
    private String menuNmae;
    private String permissionCode;
    private String permissionName;
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuNmae() {
        return menuNmae;
    }

    public void setMenuNmae(String menuNmae) {
        this.menuNmae = menuNmae;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
