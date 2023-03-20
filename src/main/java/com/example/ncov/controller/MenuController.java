package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.Menu;
import com.example.ncov.entity.User;
import com.example.ncov.service.MenuService;
import com.example.ncov.service.RoleService;
import com.example.ncov.utils.TreeNode;
import com.example.ncov.utils.TreeNodeBuilder;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.MenuVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/toMenu")
    public String toMenu(){
        return "menu/menu";
    }

    /**
     * 加载所有菜单
     *
     */

    @RequestMapping("/loadAllMenu")
    @ResponseBody
    public DataView loadAllMenu(MenuVb menuVb){
        IPage<Menu> page = new Page<>(menuVb.getPage(), menuVb.getLimit());
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        //根据前台传入菜单名称进行判空，位于数据库title列，传出参数
        queryWrapper.like(StringUtils.isNotBlank(menuVb.getTitle()),"title",menuVb.getTitle());
        queryWrapper.orderByAsc("ordernum");
        menuService.page(page,queryWrapper);
        return new DataView(page.getTotal(),page.getRecords());
    }

    /**
     * 加载下拉菜单数据和数据dtree
     */
    @RequestMapping("/loadMenuManagerLeftTreeJson")
    @ResponseBody
    public DataView loadMenuManagerLeftTreeJson(){
        //拿出菜单列表
        List<Menu> list = menuService.list();
        List<TreeNode> treeNodes = new ArrayList<>();
        //遍历菜单数据把list放入menu
        for (Menu menu:list) {
            boolean open = menu.getOpen() == 1 ? true : false;
            //传入ID，父级id，title，展开属性
            treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getTitle(),open));
        }
        return new DataView(treeNodes);

    }

    /**
     * 加载菜单赋值最大的排序码+1
     * 条件查询：倒序排序，只取1条，后+1
     */
    @RequestMapping("/loadMenuMaxOrderNum")
    @ResponseBody
    //map键string，类型object，返回map型
    public Map<String,Object> loadMenuMaxOrderNum(){
        Map<String,Object> map = new HashMap<>();
        //查到最大id
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        //倒序
        queryWrapper.orderByDesc("ordernum");
        //只查询当前页第1页分页大小1条数据，得到最大值
        IPage<Menu> page = new Page<>(1,1);
        List<Menu> list = menuService.page(page, queryWrapper).getRecords();
        //得到menu菜单实体里的ordernum值并+1
        map.put("value",list.get(0).getOrdernum()+1);
        return map;
    }

    /**
     * 新增菜单
     */
    @RequestMapping("/addMenu")
    @ResponseBody
    //Menu接收前台传入的表单
    public DataView addMenu(Menu menu){
        DataView dataView = new DataView();
        menu.setType("menu");
        //把menu保存
        boolean save = menuService.save(menu);
        if (!save){
            dataView.setCode(100);
            dataView.setMsg("添加数据失败");
            return dataView;
        }
        dataView.setMsg("添加数据成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 更新菜单
     * */
    @RequestMapping("/updateMenu")
    @ResponseBody
    public DataView updateMenu(Menu menu){
        menuService.updateById(menu);
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("更新菜单成功");
        return dataView;
    }

    /**
     * 判断可否删菜单
     * 判断有无子类ID,无则可删
     *
     */
    //转入menu菜单属性
    @RequestMapping("/checkMenuHasChildrenNode")
    @ResponseBody
    public Map<String,Object> checkChildrenNode(Menu menu){
        Map<String,Object> map = new HashMap<>();
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        //从菜单menu获得id判断其pid是否为1
        queryWrapper.eq("pid",menu.getId());
        //list列表为菜单栏
        List<Menu> list = menuService.list(queryWrapper);
        //若有数据，则为父类
        if (list.size()>0){
            map.put("value",true);
        }else {
            map.put("value",false);
        }
        return map;
    }

    /**
     * 删除菜单
     */
    @RequestMapping("/deleteMenu")
    @ResponseBody
    public DataView deleteMenu(Menu menu){
        menuService.removeById(menu.getId());
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("删除菜单成功");
        return dataView;
    }
    /**
     * 加载主页面index的菜单栏
     * 不同用户登录显示不同菜单
     */
    @RequestMapping("/loadIndexLeftMenuJson")
    @ResponseBody
    public DataView loadIndexLeftMenuJson(Menu menu, HttpSession session){
        //带条件查询菜单
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        List<Menu> list = null;
        //条件查询[管理员-全部，其他-条件]
        //通过seesion拿到用户id
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();


        if (user.getUsername().equals("admin") || StringUtils.equals(user.getUsername(),"admin")){
            list = menuService.list();
        }else {
            //根据用户id查出所拥有的角色id，rid
            List<Integer> currentUserRoleIds = roleService.queryUserRoleById(userId);
            //定义去重方法的对象

            //去重
            Set<Integer> mids = new HashSet<>();
            for (Integer rid : currentUserRoleIds){
                //根据角色id查询菜单id
                List<Integer> permissionIds = roleService.queryAllPermissionsByRoleId(rid);
                //菜单栏id和角色id去重(只是去重)
                mids.addAll(permissionIds);
            }


            //根据角色id查询菜单id
            if (mids.size()>0){
                //查询id中包含mids的值
                queryWrapper.in("id",mids);
                list = menuService.list(queryWrapper);
            }
        }

        //构造层级关系
        List<TreeNode> treeNodes = new ArrayList<>();
        //把取得的数据遍历
        for (Menu m:list){
            Integer id = m.getId();
            Integer pid = m.getPid();
            String title = m.getTitle();
            String icon = m.getIcon();
            String href = m.getHref();
            boolean open = m.getOpen().equals(1) ? true : false;
            //交给treeNodes存储数据
            treeNodes.add(new TreeNode(id,pid,title,icon,href,open));
        }

        //层级关系，若为0则父节点,梳理层级关系
        List<TreeNode> nodeList = TreeNodeBuilder.build(treeNodes, 0);
        return new DataView(nodeList);



    }
}
