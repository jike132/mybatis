package com.cmos.app.service.impl;

import com.cmos.app.bean.Users;
import com.cmos.app.dao.dao.UsersMapper;
import com.cmos.app.service.IUserService;
import com.cmos.app.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
//    @Autowired
//    PasswordHelper passwordHelper;
//    @Autowired
//    UsersMapper usersMapper;
//    @Autowired
//    Users users;

    @Override
    public Users createUser(Users user) {
//        passwordHelper.encryptPassword(user);
//      int i=  usersMapper.insertSelective(user);
//        if(i>0){
//            return user;
//        }
       return null;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
//        users.setId(userId);
//        users.setPassword(newPassword);
//        passwordHelper.encryptPassword(users);
//       usersMapper.updateByPrimaryKey(users);
    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public Users findByUsername(String username) {
        return null;
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}
