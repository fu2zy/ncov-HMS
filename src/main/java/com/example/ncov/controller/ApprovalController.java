package com.example.ncov.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.Approval;

import com.example.ncov.entity.HealthClock;
import com.example.ncov.entity.Role;
import com.example.ncov.entity.User;
import com.example.ncov.enums.ApprovalNodeStatusEnum;
import com.example.ncov.service.ApprovalService;
import com.example.ncov.service.RoleService;
import com.example.ncov.vb.ApprovalVb;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.HealthClockVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ApprovalService approvalService;

    @RequestMapping("/toApproval")
    public String toApproval(){
        return "approval/approval";
    }


    @RequestMapping("/loadMyApproval")
    @ResponseBody
//    public DataView loadMyApproval(ApprovalVb approvalVb, HttpSession session){
//        // 1.取到
//        User user = (User) session.getAttribute("user");
//        if (StringUtils.isNotEmpty(user.getUsername())){
//            String username = user.getUsername();
//            Integer uid = user.getId();
//            IPage<Approval> page = new Page<>(approvalVb.getPage(),approvalVb.getLimit());
//            QueryWrapper<Approval> queryWrapper = new QueryWrapper();
//            queryWrapper.like(StringUtils.isNotBlank(String.valueOf(uid)),"uid",uid);
//            approvalService.page(page, queryWrapper);
//
//            // 处理名字
//            List<Approval> records = page.getRecords();
//            for (Approval a:records){
//                a.setUsername(username);
//            }
//            return new DataView(page.getTotal(),page.getRecords());
//        }
//        return new DataView();
//    }


    public DataView loadMyApproval(ApprovalVb approvalVb, HttpSession session){
        User user = (User) session.getAttribute("user");
        //查询所有带有模糊查询条件
        String username = user.getUsername();
        IPage<Approval> page = new Page<>(approvalVb.getPage(), approvalVb.getLimit());
        QueryWrapper<Approval> queryWrapper = new QueryWrapper<>();
        //1满足条件追加，2找到数据库列，3查出当前变量值
        queryWrapper.like(approvalVb.getUsername()!=null,"username",approvalVb.getUsername());
        queryWrapper.eq(approvalVb.getPhone()!=null,"phone",approvalVb.getPhone());
        approvalService.page(page,queryWrapper);
        List<Approval> records = page.getRecords();
            for (Approval a:records){
                a.getUsername();
            }
        return new DataView(page.getTotal(),page.getRecords());
    }

    @RequestMapping("/addApproval")
    @ResponseBody
    public DataView addApproval(Approval approval,HttpSession session){
        approval.setCreateTime(new Date());
        // 未提交状态没有 直接提交
        User user = (User)session.getAttribute("user");
        Integer id = user.getId();
        approval.setUid(id);

        List<Integer> role = roleService.queryUserRoleById(id);
        Integer integer = role.get(0);
        Role byId = roleService.getById(integer);
        String roleName = byId.getName();
        // 判断角色
        if (StringUtils.equals(roleName,"管理员") || StringUtils.equals(roleName,"学生")){
            approval.setNodeStatus(ApprovalNodeStatusEnum.TEACHER_ING.getCode());
        }else if(StringUtils.equals(roleName,"教师")){
            approval.setNodeStatus(ApprovalNodeStatusEnum.COLLEGE_ING.getCode());
        }else if(StringUtils.equals(roleName,"学院院长")){
            approval.setNodeStatus(ApprovalNodeStatusEnum.COLLEGE_PASSED.getCode());
        }else{
            approval.setNodeStatus(ApprovalNodeStatusEnum.TEACHER_ING.getCode());
        }

        approvalService.save(approval);
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("申请请假成功！");
        return dataView;
    }

    @RequestMapping("/successApproval")
    @ResponseBody
    public DataView successApproval(Approval approval, HttpSession session){
        DataView dataView = new DataView();
        approval.setUpdateTime(new Date());
        // 1.首先判断是不是在审核状态
        User user = (User)session.getAttribute("user");
        Integer id = user.getId();
        String username = user.getUsername();
        approval.setUid(id);

        List<Integer> role = roleService.queryUserRoleById(id);
        Integer integer = role.get(0);
        Role byId = roleService.getById(integer);
        String roleName = byId.getName();

        if (StringUtils.equals(roleName,"学生")){
            dataView.setCode(100);
            dataView.setMsg(roleName+"角色不能进行审批");
            return dataView;
        }

        // 2.查询节点状态
        Approval serviceById = approvalService.getById(approval.getId());
        Integer nodeStatus = serviceById.getNodeStatus();

        // 如果是审批中的状态，才可以进行审批同意
        if ((StringUtils.equals(String.valueOf(ApprovalNodeStatusEnum.TEACHER_ING.getCode()),String.valueOf(nodeStatus)))
                || (StringUtils.equals(String.valueOf(ApprovalNodeStatusEnum.COLLEGE_ING.getCode()),String.valueOf(nodeStatus)))
        ){
            if(StringUtils.equals(roleName,"管理员")){
                approval.setNodeStatus(ApprovalNodeStatusEnum.COLLEGE_PASSED.getCode());
            }else if(StringUtils.equals(roleName,"教师")) {
                approval.setNodeStatus(ApprovalNodeStatusEnum.TEACHER_PASSED.getCode());
            }else if(StringUtils.equals(roleName,"学院院长")){
                approval.setNodeStatus(ApprovalNodeStatusEnum.COLLEGE_PASSED.getCode());
            }else{
                approval.setNodeStatus(ApprovalNodeStatusEnum.TEACHER_PASSED.getCode());
            }

            approvalService.updateById(approval);
            dataView.setCode(200);
            dataView.setMsg(username+"角色"+roleName+"审批成功！");
            return dataView;
        }

        dataView.setCode(100);
        dataView.setMsg("此状态不能进行审批！");
        return dataView;

        // 2.根据老师和院系 进行节点状态的改变

        // 3.更新


    }

    @RequestMapping("/rejectApproval")
    @ResponseBody
    public DataView rejectApproval(Approval approval, HttpSession session){
        DataView dataView = new DataView();
        approval.setUpdateTime(new Date());
        // 1.首先判断是不是在审核状态
        User user = (User)session.getAttribute("user");
        Integer id = user.getId();
        String username = user.getUsername();
        approval.setUid(id);

        List<Integer> role = roleService.queryUserRoleById(id);
        Integer integer = role.get(0);
        Role byId = roleService.getById(integer);
        String roleName = byId.getName();

        if (StringUtils.equals(roleName,"学生")){
            dataView.setCode(100);
            dataView.setMsg(roleName+"角色不能进行审批");
            return dataView;
        }

        // 2.查询节点状态
        Approval serviceById = approvalService.getById(approval.getId());
        Integer nodeStatus = serviceById.getNodeStatus();

        // 如果是审批中的状态，才可以进行审批同意
        if ((StringUtils.equals(String.valueOf(ApprovalNodeStatusEnum.TEACHER_ING.getCode()),String.valueOf(nodeStatus)))
                || (StringUtils.equals(String.valueOf(ApprovalNodeStatusEnum.COLLEGE_ING.getCode()),String.valueOf(nodeStatus)))
        ){
            if(StringUtils.equals(roleName,"管理员")){
                approval.setNodeStatus(ApprovalNodeStatusEnum.COLLEGE_REJECTED.getCode());
            }else if(StringUtils.equals(roleName,"教师")) {
                approval.setNodeStatus(ApprovalNodeStatusEnum.TEACHER_REJECTED.getCode());
            }else if(StringUtils.equals(roleName,"学院院长")){
                approval.setNodeStatus(ApprovalNodeStatusEnum.COLLEGE_REJECTED.getCode());
            }else{
                approval.setNodeStatus(ApprovalNodeStatusEnum.TEACHER_REJECTED.getCode());
            }

            // 修改库
            approvalService.updateById(approval);
            dataView.setCode(200);
            dataView.setMsg(username+"角色"+roleName+"驳回成功！");
            return dataView;
        }
        dataView.setCode(100);
        dataView.setMsg("此状态不能够进行驳回！");
        return dataView;
    }

}
