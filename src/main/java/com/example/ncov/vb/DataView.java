package com.example.ncov.vb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataView {
    //定义提示消息，状态码
    private Integer code = 0;
    private String msg = "";
    private Long count = 0L;
    //返回格式不定
    private Object data;

    //
    public DataView(Long count,Object data){
        this.count = count;
        this.data = data;
    }
    //给data赋值的构造函数
    public DataView(Object data){

        this.data = data;
    }

}
