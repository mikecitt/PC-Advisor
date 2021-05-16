package com.pcadvisor.pcadvisorapi.repository;

import com.pcadvisor.pcadvisorapi.model.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {
}
