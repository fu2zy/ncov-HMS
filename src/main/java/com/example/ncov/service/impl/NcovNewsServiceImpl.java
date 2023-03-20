package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.NcovNewsMapper;
import com.example.ncov.entity.NcovNews;
import com.example.ncov.service.NcovNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NcovNewsServiceImpl extends ServiceImpl<NcovNewsMapper, NcovNews> implements NcovNewsService {
    @Autowired
    private NcovNewsMapper ncovNewsMapper;

    @Override
    public List<NcovNews> listNewsLimit5() {
        return ncovNewsMapper.listNewsNewsLimit5();
    }
}
