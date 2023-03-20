package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.GlobalDataMapper;
import com.example.ncov.entity.NcovGlobalData;
import com.example.ncov.service.GlobalService;
import org.springframework.stereotype.Service;
//GlobalServiceImpl继承ServiceImpl实现GlobalService接口
@Service
public class GlobalServiceImpl extends ServiceImpl<GlobalDataMapper, NcovGlobalData> implements GlobalService {
}
