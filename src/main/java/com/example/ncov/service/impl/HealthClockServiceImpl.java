package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.HealthClockMapper;
import com.example.ncov.entity.HealthClock;
import com.example.ncov.service.HealthClockService;
import org.springframework.stereotype.Service;

//实现类继承mp属性实现接口
@Service
public class HealthClockServiceImpl extends ServiceImpl<HealthClockMapper, HealthClock> implements HealthClockService {
}
