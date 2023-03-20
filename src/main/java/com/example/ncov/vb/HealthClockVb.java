package com.example.ncov.vb;

import com.example.ncov.entity.HealthClock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
//继承属性HealthClock拥有此实体属性
public class HealthClockVb extends HealthClock {
    private Integer page;
    private Integer limit;
}
