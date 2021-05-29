package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import lombok.Data;

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

    @NotNull
    private Integer score; // 3DMark Graphics Score
}
