package com.example.ncov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ncov.entity.NcovNews;

import java.util.List;

public interface NcovNewsService extends IService<NcovNews> {
    List<NcovNews> listNewsLimit5();
}
