package com.example.ncov.vb;

import com.example.ncov.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVb extends User {
    private Integer page;
    private Integer limit;
}
