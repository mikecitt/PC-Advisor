package com.pcadvisor.pcadvisorapi.repository;

import com.pcadvisor.pcadvisorapi.model.GPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPURepository extends JpaRepository<GPU, Long> {
}
