package com.cmos.app.service.impl;

import com.cmos.app.bean.UserRoles;
import com.cmos.app.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Override
    public UserRoles createRole(UserRoles role) {
        return null;
    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {

    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {

    }
}
