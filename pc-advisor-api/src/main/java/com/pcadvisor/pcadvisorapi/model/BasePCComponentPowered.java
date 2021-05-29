package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.Data;

@MappedSuperclass
@Data
public class BasePCComponentPowered extends BasePCComponent {
    @NotNull
    private Integer TDP; // in Watts
}
