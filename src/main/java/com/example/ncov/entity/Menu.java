package com.example.ncov.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("menu")
public class Menu {
    //ID自增
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String type;
    private String title;
    private String permission;
    private String icon;
    private String href;
    private Integer open;
    private Integer ordernum;
    private Integer available;
}
