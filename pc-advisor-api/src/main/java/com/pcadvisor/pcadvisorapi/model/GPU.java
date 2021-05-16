package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

enum GPUBrand {
    AMD,
    NVIDIA
}

@Entity
@Data
public class GPU extends BasePCComponentPowered {
    @Enumerated(EnumType.STRING)
    @NotNull
    private GPUBrand gpuBrand;
}
