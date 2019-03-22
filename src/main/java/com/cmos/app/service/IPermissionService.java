package com.cmos.app.service;

import com.cmos.app.bean.RolesPermissions;


public interface IPermissionService {

        public RolesPermissions createPermission(RolesPermissions permission);
        public void deletePermission(Long permissionId);

}
