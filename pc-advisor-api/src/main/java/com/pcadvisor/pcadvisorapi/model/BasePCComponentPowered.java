package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@Data
public class BasePCComponentPowered extends BasePCComponent {
    @NotNull
    private Integer TDP; // in Watts
}
