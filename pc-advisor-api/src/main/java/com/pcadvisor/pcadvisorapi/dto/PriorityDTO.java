package com.pcadvisor.pcadvisorapi.dto;

import lombok.Data;

@Data
public class PriorityDTO {
    private Integer cpuPriority;
    private Integer gpuPriority;
    private Integer ramPriority;
}
