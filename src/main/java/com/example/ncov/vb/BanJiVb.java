package com.example.ncov.vb;

import com.example.ncov.entity.Banji;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BanJiVb extends Banji {
    private Integer page;
    private Integer limit;
}
