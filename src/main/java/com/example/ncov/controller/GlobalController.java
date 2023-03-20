package com.example.ncov.controller;

import com.example.ncov.entity.NcovData;
import com.example.ncov.entity.NcovGlobalData;
import com.example.ncov.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GlobalController {
    @Autowired
    //注入GlobalService服务
    private GlobalService globalService;


    //跳转global页面
    @RequestMapping("/toGlobal")
    public String toGlobal(){
        return "global";
    }
    //调用注入GlobalService服务
    //把实体类数据返回前台,前台映射路径


    @RequestMapping("/queryGlobal")
    //把数据集合序列化成json实体
    @ResponseBody
    public List<NcovGlobalData> queryGlobal(){
        //调用Service查询数据库
        List<NcovGlobalData> list = globalService.list();
        return list;

    }
}
