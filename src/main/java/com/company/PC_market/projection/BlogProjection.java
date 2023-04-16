package com.company.PC_market.projection;

import com.company.PC_market.entity.Blog;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Blog.class)
public interface BlogProjection {
    Integer getId();

    String getName();
}
