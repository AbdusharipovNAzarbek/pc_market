package com.company.PC_market.repository;

import com.company.PC_market.entity.SSD;
import com.company.PC_market.projection.SsdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "ssd", excerptProjection = SsdProjection.class)
public interface SsdRepository extends JpaRepository<SSD, Integer> {
}
