package com.company.PC_market.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String name;
    private String description;
    private Integer user_id;
    private Integer backet_id;
}
