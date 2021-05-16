package com.pcadvisor.pcadvisorapi.repository;

import com.pcadvisor.pcadvisorapi.model.CPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPURepository extends JpaRepository<CPU, Long> {
}
