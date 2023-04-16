package com.company.PC_market.projection;

import com.company.PC_market.entity.RAM;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = RAM.class)
public interface RamProjection {
    Integer getId();

    String getName();
}
