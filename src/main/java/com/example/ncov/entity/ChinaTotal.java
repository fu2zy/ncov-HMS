package com.example.ncov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("china_total")
public class ChinaTotal {
    //ID自增
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String confirm;
    private String input;
    private String severe;
    private String heal;
    private String dead;
    private String suspect;
    private Date updateTime;
}
