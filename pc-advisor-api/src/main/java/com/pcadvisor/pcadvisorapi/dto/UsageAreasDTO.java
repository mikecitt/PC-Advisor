package com.pcadvisor.pcadvisorapi.dto;

import java.util.Set;

import com.pcadvisor.pcadvisorapi.model.UsageArea;

import lombok.Data;

@Data
public class UsageAreasDTO {

  private Set<UsageArea> usageAreas;
}
