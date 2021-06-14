package com.pcadvisor.pcadvisorapi.controller;

import java.util.List;

import com.pcadvisor.pcadvisorapi.model.ComputerProgram;
import com.pcadvisor.pcadvisorapi.service.ComputerProgramService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/computer-program")
public class ComputerProgramController {
  @Autowired
  private ComputerProgramService computerProgramService;

  @GetMapping
  public List<ComputerProgram> findAll() {
    return computerProgramService.findAll();
  }
}
