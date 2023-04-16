package com.company.PC_market.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String phone_number;
    private String email;
    private String address;
    private Integer order_id;
}
