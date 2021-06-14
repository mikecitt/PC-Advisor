package com.pcadvisor.pcadvisorapi.service;

import java.util.List;
import java.util.Optional;

import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherboardService {

  @Autowired
  private MotherboardRepository motherboardRepository;

  public Optional<Motherboard> findById(Long id) {
    return motherboardRepository.findById(id);
  }

  public List<Motherboard> findAll() {
    return motherboardRepository.findAll();
  }
}
