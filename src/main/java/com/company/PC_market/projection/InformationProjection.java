package com.company.PC_market.projection;

import com.company.PC_market.entity.Information;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Information.class)
public interface InformationProjection {
    Integer getId();

    String getWork_time();

    String getPhone_number();

    String getEmail();

    String getAddress();
}
