package com.example.ncov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncov.entity.Role;

import java.util.List;

public interface RoleService extends IService<Role> {
    List<Integer> queryAllPermissionsByRoleId(Integer roleId);
    //需要到Impl实现此方法

    void deleteRoleByRid(Integer rid);

    void saveRoleMenu(Integer rid, Integer mid);

    List<Integer> queryUserRoleById(Integer id);
}
