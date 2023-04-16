package com.company.PC_market.repository;

import com.company.PC_market.entity.Blog;
import com.company.PC_market.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "catalog",excerptProjection = CatalogRepository.class)
public interface CatalogRepository extends JpaRepository<Catalog,Integer> {
}
