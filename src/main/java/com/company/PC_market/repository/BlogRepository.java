package com.company.PC_market.repository;

import com.company.PC_market.entity.Blog;
import com.company.PC_market.projection.BlogProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "blog",excerptProjection = BlogProjection.class)
public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
