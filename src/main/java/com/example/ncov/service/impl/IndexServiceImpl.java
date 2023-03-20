package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.IndexMapper;
import com.example.ncov.entity.LineTrend;
import com.example.ncov.entity.NcovData;
import com.example.ncov.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//接口实现类实现该方法，继承mp实现类属性，mapper类型与实体类
public class IndexServiceImpl extends ServiceImpl<IndexMapper, NcovData> implements IndexService {
    @Autowired
    private IndexMapper indexMapper;
    @Override
    public List<LineTrend> findSevenData() {
        List<LineTrend> list = indexMapper.findSevenData();
        return list;
    }
}
