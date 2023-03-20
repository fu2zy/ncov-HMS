package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.HealthClock;
import com.example.ncov.service.HealthClockService;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.HealthClockVb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthClockController {
    @Autowired
    private HealthClockService healthClockService;

    @RequestMapping("/toHealthClock")
    public String toHealthClock(){
        return "admin/healthclock";
    }

    @RequestMapping("/toStudentHealthClock")
    public String toStudentHealthClock(){
        return "admin/studenthealthclock";
    }


    /**
     * 查询所有打卡记录
     *
     * */
    @RequestMapping("/listHealthClock")
    @ResponseBody
    //返回值为DataView返回给Table使用
    public DataView listHealthClock(HealthClockVb healthClockVb){
        //查询所有带有模糊查询条件
        IPage<HealthClock> page = new Page<>(healthClockVb.getPage(), healthClockVb.getLimit());
        QueryWrapper<HealthClock> queryWrapper = new QueryWrapper<>();
        //1满足条件追加，2找到数据库列，3查出当前变量值
        queryWrapper.like(healthClockVb.getUsername()!=null,"username",healthClockVb.getUsername());
        queryWrapper.eq(healthClockVb.getPhone()!=null,"phone",healthClockVb.getPhone());
        healthClockService.page(page,queryWrapper);
        return new DataView(page.getTotal(),page.getRecords());
    }

    /**
     * 添加或修改打卡
     * */
    @RequestMapping("/addHealthClock")
    @ResponseBody
    //接收HealthClock实体
    public DataView addHealthClock(HealthClock healthClock){
        boolean b = healthClockService.saveOrUpdate(healthClock);
        DataView dataView = new DataView();
        if(b){
            dataView.setCode(200);
            dataView.setMsg("添加&修改成功");
            return dataView;
        }else {
            dataView.setCode(100);
            dataView.setMsg("添加&修改失败");
        }
        return dataView;
    }

    /**
     * 删除新增或修改
     * 根据id删除
     **/
    @RequestMapping("/deleteHealthClockById")
    @ResponseBody
    public DataView deleteHealthClockById(Integer id){
        healthClockService.removeById(id);
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("删除成功");
        return dataView;
    }
}
