package com.pcadvisor.pcadvisorapi.dto;

import java.util.HashSet;
import java.util.Set;

import com.pcadvisor.pcadvisorapi.model.ComputerProgram;

import lombok.Data;

@Data
public class ComputerProgramsDTO {

  private Set<ComputerProgram> computerPrograms;

  public ComputerProgramsDTO() {
    computerPrograms = new HashSet<ComputerProgram>();
  }
}
