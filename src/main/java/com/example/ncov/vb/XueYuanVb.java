package com.example.ncov.vb;

import com.example.ncov.entity.XueYuan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class XueYuanVb extends XueYuan {
    private Integer page;
    private Integer limit;
}
