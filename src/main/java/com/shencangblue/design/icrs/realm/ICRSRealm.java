package com.shencangblue.design.icrs.realm;
import com.shencangblue.design.icrs.model.Student;
import com.shencangblue.design.icrs.service.StudentService;
import com.shencangblue.design.icrs.service.admin.AdminPermissionService;
import com.shencangblue.design.icrs.service.admin.AdminRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ICRSRealm extends AuthorizingRealm {
    @Autowired
    private StudentService studentService;

    private AdminPermissionService adminPermissionService;
    @Autowired
    private AdminRoleService adminRoleService;

    // 简单重写获取授权信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前用户的所有权限
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> permissions = adminPermissionService.listPermissionURLsByUser(username);

        // 将权限放入授权信息中
        SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
        s.setStringPermissions(permissions);
        return s;
    }


    // 获取认证信息，即根据 token 中的用户名从数据库中获取密码、盐等并返回
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String studentIdName = authenticationToken.getPrincipal().toString();
        Student student = studentService.getByStudentIdName(studentIdName);
        String passwordInDB = student.getPassword();
        String salt = student.getSalt();
        return new SimpleAuthenticationInfo(studentIdName, passwordInDB, ByteSource.Util.bytes(salt), getName());
  }
}
