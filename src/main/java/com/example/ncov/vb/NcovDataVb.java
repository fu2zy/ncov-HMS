package com.example.ncov.vb;

import com.example.ncov.entity.NcovData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NcovDataVb extends NcovData {
    private Integer page;
    private Integer limit;
}
