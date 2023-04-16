package com.company.PC_market.projection;
import com.company.PC_market.entity.Catalog;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Catalog.class)
public interface CatalogProjection {
    Integer getId();
    String getName();
}
