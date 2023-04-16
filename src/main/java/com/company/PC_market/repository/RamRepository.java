package com.company.PC_market.repository;

import com.company.PC_market.entity.RAM;
import com.company.PC_market.projection.RamProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "ram",excerptProjection = RamProjection.class)
public interface RamRepository extends JpaRepository<RAM,Integer> {
}
