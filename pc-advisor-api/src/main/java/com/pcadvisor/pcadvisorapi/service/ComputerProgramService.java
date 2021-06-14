package com.pcadvisor.pcadvisorapi.service;

import java.util.List;

import com.pcadvisor.pcadvisorapi.model.ComputerProgram;
import com.pcadvisor.pcadvisorapi.repository.ComputerProgramRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerProgramService {
  @Autowired
  private ComputerProgramRepository computerProgramRepository;

  public List<ComputerProgram> findAll() {
    return computerProgramRepository.findAll();
  }
}
