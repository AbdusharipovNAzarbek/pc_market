package com.company.PC_market.repository;

import com.company.PC_market.entity.Brand;
import com.company.PC_market.projection.BrandProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "brand", excerptProjection = BrandProjection.class)
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
