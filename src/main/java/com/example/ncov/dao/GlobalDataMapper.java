package com.example.ncov.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncov.entity.NcovGlobalData;

//继承mp属性添加泛型类型NcovGlobalData
public interface GlobalDataMapper extends BaseMapper<NcovGlobalData> {
}
