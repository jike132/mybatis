package com.cmos.app.service.impl;

import com.cmos.app.bean.RolesPermissions;
import com.cmos.app.service.IPermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Override
    public RolesPermissions createPermission(RolesPermissions permission) {
        return null;
    }

    @Override
    public void deletePermission(Long permissionId) {

    }
}
