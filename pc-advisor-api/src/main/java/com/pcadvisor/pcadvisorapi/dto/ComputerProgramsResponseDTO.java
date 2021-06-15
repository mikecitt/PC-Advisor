package com.pcadvisor.pcadvisorapi.dto;

import java.util.HashSet;
import java.util.Set;

import com.pcadvisor.pcadvisorapi.model.ComputerProgram;

import lombok.Data;

@Data
public class ComputerProgramsResponseDTO {

  private Set<ComputerProgram> computerPrograms;

  public ComputerProgramsResponseDTO() {
    computerPrograms = new HashSet<ComputerProgram>();
  }
}
