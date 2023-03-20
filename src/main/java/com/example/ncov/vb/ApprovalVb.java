package com.example.ncov.vb;

import com.example.ncov.entity.Approval;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApprovalVb extends Approval {
    private Integer page;
    private Integer limit;
}
