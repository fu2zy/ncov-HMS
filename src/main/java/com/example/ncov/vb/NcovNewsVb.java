package com.example.ncov.vb;

import com.example.ncov.entity.NcovNews;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NcovNewsVb extends NcovNews {
    private Integer page;
    private Integer limit;
}
