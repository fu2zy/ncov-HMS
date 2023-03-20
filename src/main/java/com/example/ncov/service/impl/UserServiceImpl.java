package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.RoleMapper;
import com.example.ncov.dao.UserMapper;
import com.example.ncov.entity.User;
import com.example.ncov.service.RoleService;
import com.example.ncov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//继承mp的ServiceImpl属性UserMapper，实体类实现接口UserService
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    //注入userMapper完成登录
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User login(String username, String password) {
        //userMapper的自建login方法
        return userMapper.login(username,password);
    }

    @Override
    public void saveUserRole(Integer uid, Integer[] ids) {
        roleMapper.deleteRoleUserByUid(uid);
        if (ids!=null && ids.length>0){
            //判断非空拿出每个ids并保存
            for (Integer rid : ids){
                roleMapper.saveUserRole(uid,rid);
            }
        }
    }
}
