package com.company.PC_market.projection;

import com.company.PC_market.entity.CPU;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = CPU.class)
public interface CpuProjection {
    Integer getId();

    String getName();
}
