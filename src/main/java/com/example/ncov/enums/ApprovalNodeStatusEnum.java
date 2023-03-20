package com.example.ncov.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请假审批节点的枚举类型
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ApprovalNodeStatusEnum {

    // 用于不常去改变的类的常量

    NO_SUBMIT(0,"未提交"),
    TEACHER_ING(1,"老师正在审核中"),
    TEACHER_REJECTED(2,"老师已驳回"),
    TEACHER_PASSED(3,"老师审核通过"),

    COLLEGE_ING(4,"院系正在审核中"),
    COLLEGE_REJECTED(5,"院系已驳回"),
    COLLEGE_PASSED(6,"院系审核通过");

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
