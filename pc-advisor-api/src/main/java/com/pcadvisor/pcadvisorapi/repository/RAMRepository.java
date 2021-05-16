package com.pcadvisor.pcadvisorapi.repository;

import com.pcadvisor.pcadvisorapi.model.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMRepository extends JpaRepository<RAM, Long> {
}
