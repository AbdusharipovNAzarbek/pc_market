package com.company.PC_market.projection;

import com.company.PC_market.entity.Brand;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Brand.class)
public interface BrandProjection {
    Integer getId();
    String getName();
}
