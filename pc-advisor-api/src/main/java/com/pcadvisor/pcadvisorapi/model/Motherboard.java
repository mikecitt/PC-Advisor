package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Motherboard extends BasePCComponent {
    @NotNull
    @Enumerated(EnumType.STRING)
    private Chipset chipset;
}
