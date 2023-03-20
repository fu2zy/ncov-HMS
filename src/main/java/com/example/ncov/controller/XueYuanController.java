package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.NcovNews;
import com.example.ncov.entity.XueYuan;
import com.example.ncov.service.NcovNewsService;
import com.example.ncov.service.XueYuanService;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.NcovNewsVb;
import com.example.ncov.vb.XueYuanVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/xueyuan")
public class XueYuanController {
    @Autowired
    private XueYuanService xueYuanService;


    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/toXueYuan")
    public String toNews(){
        return "xueyuan/xueyuan";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/listXueYuan")
    @ResponseBody
    public DataView listNews(XueYuanVb xueYuanVb){
        QueryWrapper<XueYuan> queryWrapper = new QueryWrapper<>();
        //通过title查库
        queryWrapper.like(StringUtils.isNotBlank(xueYuanVb.getName()),"name",xueYuanVb.getName());
        IPage<XueYuan> iPage = new Page<>(xueYuanVb.getPage(), xueYuanVb.getLimit());
        //分页查询
        xueYuanService.page(iPage,queryWrapper);
        return new DataView(iPage.getTotal(),iPage.getRecords());
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public DataView deleteById(Integer id){
        xueYuanService.removeById(id);
        DataView dataView = new DataView();
        dataView.setMsg("删除成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 添加或修改
     * @return
     */
    @RequestMapping("/addOrUpdateXueYuan")
    @ResponseBody
    public DataView addOrUpdate(XueYuan xueYuan){
        xueYuanService.saveOrUpdate(xueYuan);
        DataView dataView = new DataView();
        dataView.setMsg("添加或修改成功");
        dataView.setCode(200);
        return dataView;
    }


}
