package com.pcadvisor.pcadvisorapi.dto;

import com.pcadvisor.pcadvisorapi.model.CPUBrand;

import lombok.Data;

@Data
public class SearchRequestDTO {

  private CPUBrand cpuBrand;

  private Integer cores;
}
