package com.pcadvisor.pcadvisorapi.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class ComputerProgramsRequestDTO {

    private Set<ComputerProgramRequestDTO> computerPrograms;

    public ComputerProgramsRequestDTO() {
        computerPrograms = new HashSet<ComputerProgramRequestDTO>();
    }
}
