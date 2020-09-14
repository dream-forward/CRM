package com.hy.crm.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.user.pojo.User;
import com.hy.crm.user.service.IRoleService;
import com.hy.crm.user.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author 旗木卡卡西
 * @date 2020/8/4 9:06
 */
public class LoginRealm extends AuthorizingRealm {
    @Autowired
   private IUserService userServiceImpl;

    @Autowired
    private IRoleService roleServiceImpl;
    /*
登录认证
* */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*强转成实现类  可以获取controller里传的用户名和密码*/
        UsernamePasswordToken upToken=(UsernamePasswordToken)authenticationToken;
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("useraccount",upToken.getUsername());
        User user=userServiceImpl.getOne(queryWrapper);
        if(null==user){
            throw new UnknownAccountException("该用户不存在");
        }
        /*加上盐再传过去进行比对*/
        ByteSource miwen=ByteSource.Util.bytes(upToken.getUsername());
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user.getUseraccount(),user.getUserpassword(),miwen,getName());
        return simpleAuthenticationInfo;
    }
    /*
    登录授权
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //先获取主身分
        Object useraccount = principalCollection.getPrimaryPrincipal();
        //根据用户名查询得到角色和权限
        Set<String> roles = roleServiceImpl.queryRoleByuser(useraccount.toString());
//返回授权信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }


}
