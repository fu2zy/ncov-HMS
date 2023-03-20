package com.example.ncov.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncov.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    //创建userMapper的login方法,利用SQL语句判断username和password
    //旧方法已不用
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(String username, String password);
    //数据返回到Controller的user对象
}
