package com.pcadvisor.pcadvisorapi.repository;

import com.pcadvisor.pcadvisorapi.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
}
