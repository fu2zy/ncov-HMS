package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.ChinaTotalMapper;
import com.example.ncov.entity.ChinaTotal;
import com.example.ncov.service.ChinaTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChinaTotalServiceImpl extends ServiceImpl<ChinaTotalMapper, ChinaTotal> implements ChinaTotalService {
    @Autowired
    private ChinaTotalMapper chinaTotalMapper;

    @Override
    public Integer maxID() {
        return chinaTotalMapper.maxID();
    }
}
