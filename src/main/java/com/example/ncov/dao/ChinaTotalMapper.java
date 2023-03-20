package com.example.ncov.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncov.entity.ChinaTotal;
import org.apache.ibatis.annotations.Select;

public interface ChinaTotalMapper extends BaseMapper<ChinaTotal> {
    @Select("select max(id) from china_total")

    Integer maxID();
}
