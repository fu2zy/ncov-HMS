package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.NcovNews;
import com.example.ncov.service.NcovNewsService;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.NcovNewsVb;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/news")
public class NcovNewsController {
    @Autowired
    private NcovNewsService ncovNewsService;


    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/toNews")
    public String toNews(){
        return "news/news";
    }

    /**
     * 查询
     * @return
     */
    @RequestMapping("/listNews")
    @ResponseBody
    public DataView listNews(NcovNewsVb ncovNewsVb){
        QueryWrapper<NcovNews> queryWrapper = new QueryWrapper<>();
        //通过title查库
        queryWrapper.like(StringUtils.isNotBlank(ncovNewsVb.getTitle()),"title",ncovNewsVb.getTitle());
        IPage<NcovNews> iPage = new Page<>(ncovNewsVb.getPage(), ncovNewsVb.getLimit());
        //分页查询
        ncovNewsService.page(iPage,queryWrapper);
        return new DataView(iPage.getTotal(),iPage.getRecords());
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public DataView deleteById(Integer id){
        ncovNewsService.removeById(id);
        DataView dataView = new DataView();
        dataView.setMsg("删除成功");
        dataView.setCode(200);
        return dataView;
    }

    /**
     * 添加或修改
     * @return
     */
    @RequestMapping("/addOrUpdateNews")
    @ResponseBody
    public DataView addOrUpdate(NcovNews ncovNews){
        ncovNews.setCreateTime(new Date());
        ncovNewsService.saveOrUpdate(ncovNews);
        DataView dataView = new DataView();
        dataView.setMsg("添加或修改成功");
        dataView.setCode(200);
        return dataView;
    }


}
