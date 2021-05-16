package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

enum GPUBrand {
    AMD,
    NVIDIA
}

@Data
public class GPU extends BasePCComponentPowered {
    private GPUBrand gpuBrand;
}
