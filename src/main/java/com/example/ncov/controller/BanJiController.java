package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.Banji;
import com.example.ncov.entity.XueYuan;
import com.example.ncov.service.BanjiService;
import com.example.ncov.service.XueYuanService;
import com.example.ncov.vb.BanJiVb;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.XueYuanVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/banji")
public class BanJiController {
    @Autowired
    private BanjiService banjiService;


    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/toBanJi")
    public String toNews(){
        return "banji/banji";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/listBanJi")
    @ResponseBody
    public DataView listNews(BanJiVb banJiVb){
        QueryWrapper<Banji> queryWrapper = new QueryWrapper<>();
        //通过title查库
        queryWrapper.like(StringUtils.isNotBlank(banJiVb.getName()),"name",banJiVb.getName());
        IPage<Banji> iPage = new Page<>(banJiVb.getPage(), banJiVb.getLimit());
        //分页查询
        banjiService.page(iPage,queryWrapper);
        return new DataView(iPage.getTotal(),iPage.getRecords());
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public DataView deleteById(Integer id){
        banjiService.removeById(id);
        DataView dataView = new DataView();
        dataView.setMsg("删除成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 添加或修改
     * @return
     */
    @RequestMapping("/addOrUpdateBanJi")
    @ResponseBody
    public DataView addOrUpdate(Banji banji){
        banjiService.saveOrUpdate(banji);
        DataView dataView = new DataView();
        dataView.setMsg("添加或修改成功");
        dataView.setCode(200);
        return dataView;
    }


}
