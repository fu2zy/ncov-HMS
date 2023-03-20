package com.example.ncov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ncov.dao.BanjiMapper;
import com.example.ncov.entity.Banji;
import com.example.ncov.service.BanjiService;
import org.springframework.stereotype.Service;

@Service
public class BanjiServiceImpl extends ServiceImpl<BanjiMapper, Banji> implements BanjiService {
}
