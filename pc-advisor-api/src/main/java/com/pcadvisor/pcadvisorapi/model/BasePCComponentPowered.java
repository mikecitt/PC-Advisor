package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

@Data
public class BasePCComponentPowered extends BasePCComponent {
    private Integer powerUsage; // in Watts
}
