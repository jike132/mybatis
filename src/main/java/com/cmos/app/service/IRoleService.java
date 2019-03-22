package com.cmos.app.service;


import com.cmos.app.bean.UserRoles;

public interface IRoleService {
    public UserRoles createRole(UserRoles role);
    public void deleteRole(Long roleId);
    //添加角色-权限之间关系
    public void correlationPermissions(Long roleId, Long... permissionIds);
    //移除角色-权限之间关系
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);//
}
