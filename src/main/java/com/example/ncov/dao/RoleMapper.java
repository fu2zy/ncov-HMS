package com.example.ncov.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncov.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//添加role实体封装
public interface RoleMapper extends BaseMapper<Role> {
    //根据rid查询所有mid，若rid=1则返回rid为1的mid值，最后返回到controller
    @Select("select mid from role_menu where rid = #{roleId}")
    List<Integer> queryMidByRid(Integer roleId);

    //分配权限前把对应rid信息删除
    @Delete("delete from role_menu where rid = #{rid}")
    void deleteRoleByRid(Integer rid);

    //保存角色相对应的菜单权限
    @Insert("Insert into role_menu(rid,mid) values (#{rid},#{mid})")
    void saveRoleMenu(Integer rid, Integer mid);

    //根据用户id查询所有的角色
    @Select("select rid from user_role where uid = #{id}")
    List<Integer> queryUserRoleById(Integer id);


    //先删除之前用户与角色权限关系
    @Delete("delete from user_role where uid = #{uid}")
    void deleteRoleUserByUid(Integer uid);

    //保存分配的用户与角色权限关系
    @Insert("insert into user_role(uid,rid) values(#{uid},#{rid})")
    void saveUserRole(Integer uid, Integer rid);
}
