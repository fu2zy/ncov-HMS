package com.example.ncov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncov.entity.LineTrend;
import com.example.ncov.entity.NcovData;

import java.util.List;

public interface IndexService extends IService<NcovData> {
    //定义findSevenData方法接口
    List<LineTrend> findSevenData();
}
