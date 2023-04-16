package com.company.PC_market.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.StringToLdapNameConverter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcMarketDto {
private String name;
private Integer information_id;
private Integer backet_id;
private Integer currency_id;
private Integer catalog_id;
private Integer blog_id;
private Integer action_id;
private Integer contact_id;
}

