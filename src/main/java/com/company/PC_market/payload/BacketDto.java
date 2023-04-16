package com.company.PC_market.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BacketDto {
    private String name;
    private String description;
    private Integer products_id;
    private Double subtotal;
    private Integer quantity;
}
