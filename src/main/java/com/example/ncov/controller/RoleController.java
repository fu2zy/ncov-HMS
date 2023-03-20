package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.Menu;
import com.example.ncov.entity.Role;
import com.example.ncov.service.MenuService;
import com.example.ncov.service.RoleService;
import com.example.ncov.utils.TreeNode;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.RoleVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/toRole")
    public String toRole(){
        return "role/role";
    }

    /**
     * 查询所有角色
     */

    @RequestMapping("/loadAllRole")
    @ResponseBody
    public DataView loadAllRole(RoleVb roleVb){
        IPage<Role> page = new Page<>(roleVb.getPage(), roleVb.getLimit());
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        //1判断前台传来参数名不为空，2数据库列名，3当前传来值放入
        queryWrapper.like(StringUtils.isNotBlank(roleVb.getName()),"name",roleVb.getName());
        queryWrapper.like(StringUtils.isNotBlank(roleVb.getRemark()),"remark",roleVb.getRemark());
        roleService.page(page,queryWrapper);
        return new DataView(page.getTotal(),page.getRecords());

    }

    /**
     * 添加角色
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public DataView addRole(Role role){
        roleService.save(role);
        DataView dataView = new DataView();
        dataView.setMsg("添加角色成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 修改角色
     */
    @RequestMapping("/updateRole")
    @ResponseBody
    public DataView updateRole(Role role){
        roleService.saveOrUpdate(role);
        DataView dataView = new DataView();
        dataView.setMsg("修改角色成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 删除角色
     */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public DataView deleteRole(Role role){
        roleService.removeById(role.getId());
        DataView dataView = new DataView();
        dataView.setMsg("删除角色成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 初始化下拉列表的权限
     * 根据角色查询菜单
     */
    @RequestMapping("/initPermissionByRoleId")
    @ResponseBody
    public DataView initPermissionByRoleId(Integer roleId){
        //查出所有菜单权限
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();

        List<Menu> allPermissions = menuService.list();
        //根据角色roleId查询所有的菜单menuId
        List<Integer> currentRolePermissions = roleService.queryAllPermissionsByRoleId(roleId);
        //根据role和menu的所有的ID，去查询菜单和角色的数据
        List<Menu> menus = null;
        //查询到menuId和roleId则查询其数据
        if (currentRolePermissions.size()>0){
            //id是否存在，有则放入currentRolePermissions
            queryWrapper.in("id",currentRolePermissions);
            menus = menuService.list(queryWrapper);

        }else {
            menus = new ArrayList<>();
        }
        //返回前台,构造层次
        List<TreeNode> nodes = new ArrayList<>();
        for (Menu allPermission:allPermissions){
            String checkArr = "0";
            for (Menu currentPermission:menus){
                if (allPermission.getId().equals(currentPermission.getId())){
                    //通过标志位表示展开或不展开
                    checkArr = "1";
                    break;
                }
            }
            //1展开true,否则不展fasle
            Boolean spread = (allPermission.getOpen()==null || allPermission.getOpen() == 1) ?true:false;
            //添加树节点，id，pid，title，是否展开，标志位
            nodes.add(new TreeNode(allPermission.getId(),allPermission.getPid(),allPermission.getTitle(),spread,checkArr));
        }
        return new DataView(nodes);
    }
    /**
     * 点击确认分配权限，插入数据表
     */
    @RequestMapping("/saveRolePermission")
    @ResponseBody
    //从前台接收两组数据，一个rid,一个数组包含多个权限
    public DataView saveRolePermission(Integer rid,Integer[] mids){
        //自定义方法,根据rid删除之前的mid权限,在RoleService创建方法
        roleService.deleteRoleByRid(rid);
        //有值才分配
        if (mids!=null && mids.length>0){
            //批量保存
            for (Integer mid : mids){
                roleService.saveRoleMenu(rid,mid);
            }
        }
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("权限分配成功");
        return dataView;
    }

}
