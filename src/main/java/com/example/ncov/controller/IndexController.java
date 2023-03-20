package com.example.ncov.controller;

import com.example.ncov.entity.ChinaTotal;
import com.example.ncov.entity.LineTrend;
import com.example.ncov.entity.NcovData;
import com.example.ncov.entity.NcovNews;
import com.example.ncov.service.ChinaTotalService;
import com.example.ncov.service.IndexService;
import com.example.ncov.service.NcovNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//打开首页index发送请求到controller
public class IndexController {
//注入Service
    @Autowired
    private IndexService indexService;
    @Autowired
    private ChinaTotalService chinaTotalService;
    @Autowired
    private NcovNewsService ncovNewsService;

    /**
     *主控页[嵌套china]
     */
    @RequestMapping("/")
    public String index(Model model) throws ParseException{
        //找到id最大的一条数据
//        Integer id = chinaTotalService.maxID();
//        //根据id查找数据
//        ChinaTotal chinaTotal = chinaTotalService.getById(id);
//        model.addAttribute("chinaTotal",chinaTotal);
        //给前台解析数据
        return "index";
    }

    /**
     *china地图页面的新闻页面
     */
    @RequestMapping("/toChina")
    public String toChina(Model model) throws ParseException{
//        Integer id = chinaTotalService.maxID();
//        ChinaTotal chinaTotal = chinaTotalService.getById(id);
//        model.addAttribute("chinaTotal",chinaTotal);

        //查询新闻,自定方法查5条数据
        List<NcovNews> newsList = ncovNewsService.listNewsLimit5();
        //放入前台容器
        model.addAttribute("newsList",newsList);

        return "China";
    }

    //把实体类数据返回前台,前台映射路径
    @RequestMapping("/query")
    //把数据集合序列化成json实体
    @ResponseBody
    public List<NcovData> queryData(){
        //调用Service查询数据库
        List<NcovData> list = indexService.list();
        return list;

    }

    /**
     * 跳转到pie
     * **/
    @RequestMapping("/toPie")
    public String toPie(){
        return "pie";
    }

    /**
     * 查饼图数据
     * **/
    //把数据集合序列化成json实体
    @RequestMapping("/queryPie")
    @ResponseBody
    public List<NcovData> queryPieData(){
        //调用Service查询数据库
        List<NcovData> list = indexService.list();
        return list;
 }
    /**
     * 跳转到bar
     * **/
    @RequestMapping("/toBar")
    public String toBar(){
        return "bar";
    }

    @RequestMapping("/queryBar")
    @ResponseBody
    public Map<String,List<Object>> queryBarData(){
        //调用Service查询数据库,所有城市数据
        List<NcovData> list = indexService.list();
        //把城市数据封装到List集合
        List<String> cityList = new ArrayList<>();
        for (NcovData data : list){
            cityList.add(data.getName());
        }
        //所有疫情数值
        List<Integer> dataList = new ArrayList<>();
        for (NcovData data : list){
            dataList.add(data.getValue());
        }

        //创建容器Map
        Map map = new HashMap<>();
        map.put("cityList",cityList);
        map.put("dataList",dataList);

        //交给前台解析两组数据
        return map;
    }

     /**
      * 跳转到line
      * **/
    @RequestMapping("/toLine")
    public String toLine(){
        return "line";
    }

//select * from qushishuju order by create_time limit 7
    @RequestMapping("/queryLine")
    @ResponseBody
    public Map<String,List<Object>> queryLineData(){
        //近七天查询数据
        List<LineTrend> list7Day = indexService.findSevenData();
        //封装所有确诊人数
        List<Integer> confirmList = new ArrayList<>();
        //封装所有隔离人数
        List<Integer> isolationList = new ArrayList<>();
        //封装所有治愈人数
        List<Integer> cureList = new ArrayList<>();
        //封装所有死亡人数
        List<Integer> deadList = new ArrayList<>();
        //封装所有疑似人数
        List<Integer> similarList = new ArrayList<>();
        for (LineTrend data : list7Day){
            confirmList.add(data.getConfirm());
            isolationList.add(data.getIsolation());
            cureList.add(data.getCure());
            deadList.add(data.getDead());
            similarList.add(data.getSimilar());
        }
        //再用大集合撞一起
        Map map =new HashMap();
        map.put("confirmList",confirmList);
        map.put("isolationList",isolationList);
        map.put("cureList",cureList);
        map.put("deadList",deadList);
        map.put("similarList",similarList);
        return map;
    }




}
