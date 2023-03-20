package com.example.ncov.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.ncov.entity.User;
import com.example.ncov.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


//继承shiro的AuthorizingRealm方法并重写
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //重写getName方法,得到简单名
    @Override
    public String getName(){
        return this.getClass().getSimpleName();
    }
    /**
     * 认证
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //查询User对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //查询出username,从getPrincipal取得用户名
        queryWrapper.eq("username",token.getPrincipal().toString());
        User user = userService.getOne(queryWrapper);
        if (user!=null){
            //传入user对象和用户密码，类名交给shiro管理
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
            return info;

        }

        return null;
    }

    /**
     * 授权
     *
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


}
