package com.company.PC_market.repository;

import com.company.PC_market.entity.CPU;
import com.company.PC_market.projection.CpuProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cpu",excerptProjection = CpuProjection.class)
public interface CpuRepository extends JpaRepository<CPU,Integer> {
}
