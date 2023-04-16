package com.company.PC_market.projection;

import com.company.PC_market.entity.HDD;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = HDD.class)
public interface HddProjection {
    Integer getId();

    String getName();
}
