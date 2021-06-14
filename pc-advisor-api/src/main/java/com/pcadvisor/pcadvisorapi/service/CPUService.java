package com.pcadvisor.pcadvisorapi.service;

import java.util.List;
import java.util.Optional;

import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPUService {

  @Autowired
  private CPURepository cpuRepository;

  public Optional<CPU> findById(Long id) {
    return cpuRepository.findById(id);
  }

  public List<CPU> findAll() {
    return cpuRepository.findAll();
  }
}
