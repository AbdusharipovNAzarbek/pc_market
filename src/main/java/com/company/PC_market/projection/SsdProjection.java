package com.company.PC_market.projection;

import com.company.PC_market.entity.SSD;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = SSD.class)
public interface SsdProjection {
    Integer getId();

    Integer getName();
}
