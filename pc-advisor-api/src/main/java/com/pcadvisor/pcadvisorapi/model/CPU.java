package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import java.util.List;

enum CPUBrand {
    AMD,
    INTEL
}

@Data
public class CPU extends BasePCComponentPowered {
    private CPUBrand cpuBrand;
    private Integer cores;
    private Float frequency;
    private List<Chipset> compatibleChipsets;
}
