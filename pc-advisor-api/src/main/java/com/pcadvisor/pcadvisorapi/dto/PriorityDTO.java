package com.pcadvisor.pcadvisorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriorityDTO {
    private Integer cpuPriority;
    private Integer gpuPriority;
    private Integer ramPriority;
}
