package com.example.ncov.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ncov.entity.NcovData;
import com.example.ncov.service.IndexService;
import com.example.ncov.vb.DataView;
import com.example.ncov.vb.NcovDataVb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class ChinaDataAdminController {
    //复用service接口,indexService有中国地图增删改查服务
    @Autowired
    private IndexService indexService;
    //跳转页面
    @RequestMapping("toChinaManager")
    public String toChinaManager(){
        return "admin/chinadatamanager";
    }

    /**
     * 交给layui解决数据实体
     * 带分页的模糊查询
     */
    @RequestMapping("/listDataByPage")
    @ResponseBody
    //提取ncovDataVb对象,打DataView渲染成json实例
    public DataView listDataByPage(NcovDataVb ncovDataVb){
        //创建分页对象,调用mp对象IPage,当前页以及每页限制大小
        IPage<NcovData> page = new Page<>(ncovDataVb.getPage(), ncovDataVb.getLimit());
        //创建模糊查询对象，封装的对象交给mp
        QueryWrapper<NcovData> queryWrapper =new QueryWrapper<>();
        //非空执行语句,查询数据库哪一列，得出name给程序赋值
        queryWrapper.like(!(ncovDataVb.getName()==null),"name",ncovDataVb.getName());
        //疫情数据确诊倒序排列
        queryWrapper.orderByDesc("value");
        //查询数据库，调用indexService分页查询条件
        indexService.page(page,queryWrapper);
        //返回数据条数及数据内容
        DataView dataView = new DataView(page.getTotal(),page.getRecords());
        return dataView;
    }

    /**
     * 删除新增或修改
     * 根据id删除
     * */
    @RequestMapping("/china/deleteById")
    @ResponseBody
    //取得DataView状态码和提示消息,根据id删除
    public DataView deleteById(Integer id){
        indexService.removeById(id);
        DataView dataView = new DataView();
        dataView.setCode(200);
        dataView.setMsg("删除成功");
        return dataView;
    }

    /**
    * 新增或修改
    * 根据id判断，若ncovData有值则修改，无则新增
    **/
    @RequestMapping("/china/addOrUpdateChina")
    @ResponseBody
    //封装NcovData的name和value
    public DataView addChina(NcovData ncovData){
        //数据条数
        boolean save = indexService.saveOrUpdate(ncovData);
        DataView dataView = new DataView();
        if (save){
            dataView.setCode(200);
            dataView.setMsg("添加&修改成功");
            return dataView;
        }else {
            dataView.setCode(100);
            dataView.setMsg("添加失败");
            return dataView;
        }
    }
}
