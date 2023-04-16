package com.company.PC_market.projection;

import com.company.PC_market.entity.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CurrencyProjection {
    Integer getId();
    String getName();
}
