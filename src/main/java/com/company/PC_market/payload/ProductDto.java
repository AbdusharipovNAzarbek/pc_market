package com.company.PC_market.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private Double price;
    private String description;
    private Integer catalog_id;
    private Integer ssd_id;
    private Integer cpu_id;
    private Integer hdd_id;
    private Integer ram_id;
    private Integer brand_id;
}
