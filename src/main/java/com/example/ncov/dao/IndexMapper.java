package com.example.ncov.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncov.entity.LineTrend;
import com.example.ncov.entity.NcovData;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//继承mp属性添加泛型类型NcovData
public interface IndexMapper extends BaseMapper<NcovData> {

    @Select("select * from line_trend order by create_time limit 7")
    List<LineTrend> findSevenData();
}
