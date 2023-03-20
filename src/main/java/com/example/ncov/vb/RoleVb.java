package com.example.ncov.vb;

import com.example.ncov.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVb extends Role {
    private Integer page;
    private Integer limit;
}
