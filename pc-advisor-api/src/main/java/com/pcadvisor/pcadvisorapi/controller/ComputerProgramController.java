package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.model.ComputerProgram;
import com.pcadvisor.pcadvisorapi.repository.ComputerProgramRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/computer-program")
public class ComputerProgramController {
  @Autowired
  private ComputerProgramRepository computerProgramRepository;

  @GetMapping
  List<ComputerProgram> getAll() {
    return computerProgramRepository.findAll();
  }
}
