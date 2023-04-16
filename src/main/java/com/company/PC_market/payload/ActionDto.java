package com.company.PC_market.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionDto {
    private String name;
    private String description;
    private Integer products_id;
}
