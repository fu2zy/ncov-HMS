package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.Banji;
import com.example.ncov.entity.User;
import com.example.ncov.entity.XueYuan;
import com.example.ncov.service.BanjiService;
import com.example.ncov.service.RoleService;
import com.example.ncov.service.UserService;
import com.example.ncov.service.XueYuanService;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.UserVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BanjiService banjiService;
    @Autowired
    private XueYuanService xueYuanService;
    @Autowired
    private RoleService roleService;


    @RequestMapping("/toUser")
    public String toUser(){
        return "user/user";
    }

    @RequestMapping("/toChangePassword")
    public String toChangePassword(){
        return "user/changepassword";
    }

    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "user/userInfo";
    }


    /**
     *查询所有用户数据带查询条件
     */
    @RequestMapping("/loadAllUser")
    @ResponseBody
    public DataView getAllUser(UserVb userVb){
        //联表查询1
        //判断非空查询
//        if (StringUtils.isNotBlank(userVb.getUsername())){
//            //模糊查询条件，分页大小，页数
//            userService.loadUserByLeftJoin(userVb.getUsername(),userVb.getPage(),userVb.getLimit());
//        }





        //1.查出所有数据
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        IPage<User> page = new Page<>(userVb.getPage(), userVb.getLimit());
        //构造查询条件
        queryWrapper.like(StringUtils.isNotBlank(userVb.getUsername()),"username",userVb.getUsername());
        queryWrapper.eq(StringUtils.isNotBlank(userVb.getPhone()),"phone",userVb.getPhone());
        //把page和queryWrapper放入iPage
        IPage<User> iPage = userService.page(page, queryWrapper);
        //iPage[所有User数据]->banjiID->ban_ji表->得到名字->给iPage对象赋值->给User添加非数据库属性

        for (User user:iPage.getRecords()){
            //为班名赋值,赋值前查询iPage
            if (user.getBanJiId()!=null){
                //调用班级Service查库,取得User对象里的BanJiId，通过主键BanJiId查询班级表
                Banji banji = banjiService.getById(user.getBanJiId());
                user.setBanJiName(banji.getName());
            }

            //为院名赋值
            if (user.getXueYuanId()!=null){
                XueYuan xueyuan = xueYuanService.getById(user.getXueYuanId());
                user.setXueYuanName(xueyuan.getName());
            }

            //为老师赋值
            if (user.getTeacherId()!=null){
                User teacher = userService.getById(user.getTeacherId());
                user.setTeacherName(teacher.getUsername());
            }
        }
        return new DataView(iPage.getTotal(),iPage.getRecords());
    }

    /**
     * 新增用户
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public DataView addUser(User user){
        userService.save(user);
        DataView dataView = new DataView();
        dataView.setMsg("添加用户成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 修改用户
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public DataView updateUser(User user){
        userService.updateById(user);
        DataView dataView = new DataView();
        dataView.setMsg("修改用户成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 删除用户
     */
    //非参数传递，带路径，取路径的id
    @RequestMapping("/deleteUser/{id}")
    @ResponseBody
    public DataView deleteUser(@PathVariable("id") Integer id){
        userService.removeById(id);
        DataView dataView = new DataView();
        dataView.setMsg("删除用户成功");
        dataView.setCode(200);
        return dataView;
    }


    /**
     * 查询及初始化下拉列表的数据-班级
     */
    @RequestMapping("/listAllBanJi")
    @ResponseBody
    public List<Banji> listAllBanJi(){
        List<Banji> list = banjiService.list();
        return list;
    }


    /**
     * 查询及初始化下拉列表的数据-学院
     */
    @RequestMapping("/listAllXueYuan")
    @ResponseBody
    public List<XueYuan> listAllXueYuan(){
        List<XueYuan> list = xueYuanService.list();
        return list;
    }

    /**
     * 重置密码
     */
    @RequestMapping("/resetPwd/{id}")
    @ResponseBody
    public DataView resetPwd(@PathVariable("id") Integer id){
        User user = new User();
        //给id赋值，根据id修改密码
        user.setId(id);
        user.setPassword("123456");
        //mp更新操作不更新属性为空值
        userService.updateById(user);
        DataView dataView = new DataView();
        dataView.setMsg("用户重置密码成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 分配用户角色权限
     * 根据ID查询所以拥有角色
     */
    @RequestMapping("/initRoleByUserId")
    @ResponseBody
    //根据用户id查询所拥有的角色
    public DataView initRoleByUserId(Integer id){
        //查询所有角色数据返回到listMaps
        List<Map<String, Object>> listMaps = roleService.listMaps();
        //根据id查询当前登录用户所拥有角色,使用自定方法
        List<Integer> currentUserRoleIds = roleService.queryUserRoleById(id);
        //遍历所有角色与自身角色，判断前端选中状态
        for (Map<String,Object> map : listMaps){
            //标志位，默认不选
            Boolean LAY_CHECKED = false;
            Integer roleId = (Integer) map.get("id");
            for (Integer rid : currentUserRoleIds){
                //如果当前拥有的角色id与其中之一id相同，则选中
                if (rid.equals(roleId)){
                    LAY_CHECKED = true;
                    break;
                }
                //显示选中状态
            }
            map.put("LAY_CHECKED",LAY_CHECKED);
        }
        return new DataView(Long.valueOf(listMaps.size()),listMaps);
    }

    /**
     * 保存用户与角色权限间的关系
     */
    @RequestMapping("/saveUserRole")
    @ResponseBody
    //先删除在保存,根据用户uid，保存集合ids
    public DataView saveUserRole(Integer uid,Integer[] ids){
        userService.saveUserRole(uid,ids);
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("用户角色权限分配成功");
        return dataView;
    }

}
