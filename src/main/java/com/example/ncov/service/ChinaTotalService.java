package com.example.ncov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncov.entity.ChinaTotal;

public interface ChinaTotalService extends IService<ChinaTotal> {
    Integer maxID();
}
