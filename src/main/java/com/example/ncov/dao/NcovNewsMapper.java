package com.example.ncov.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ncov.entity.NcovNews;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NcovNewsMapper extends BaseMapper<NcovNews> {
    @Select("select * from nocv_news order by create_time desc limit 5")
    List<NcovNews> listNewsNewsLimit5();
}
