package com.cmos.app.test;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class LoginTest extends BaseJunit4Test {

    private void login(String configFile,String userName,String passWord) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        subject.login(token);
    }
    @Test
    public void login() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
     Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
    SecurityManager securityManager=factory.getInstance();

    SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
     Subject  subject = SecurityUtils.getSubject();
  UsernamePasswordToken token = new UsernamePasswordToken("zhang", "23");
        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("-------------------"+token+"-----------------------------");
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }
        org.junit.Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }
    @Test
    public void testCustomRealm() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }

       org.junit.Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }
    @Test
    public void testHasRole() {
        this.login("classpath:shiro-role.ini", "wang", "123");
        Subject subject = SecurityUtils.getSubject();
        //判断拥有角色：role1
        org.junit.Assert.assertTrue(subject.hasRole("role1"));
        //判断拥有角色：role1 and role2
  //      org.junit.Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        org.junit.Assert.assertEquals(true, result[0]);
        org.junit.Assert.assertEquals(true, result[1]);
        org.junit.Assert.assertEquals(false, result[2]);
    }
    @Test
    public void encript(){
        String str = "hello";

        String base64Encoded = Base64.encodeToString(str.getBytes());
        System.out.println("-------------------"+base64Encoded+"-----------------------------");

        String str2 = Base64.decodeToString(base64Encoded);
        org.junit.Assert.assertEquals(str, str2);
    }

}
