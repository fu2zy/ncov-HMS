package com.example.ncov.vb;

import com.example.ncov.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//为Menu添加 page，limit
public class MenuVb extends Menu {
    private Integer page;
    private Integer limit;
}
