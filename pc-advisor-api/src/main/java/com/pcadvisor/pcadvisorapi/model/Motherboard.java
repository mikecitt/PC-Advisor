package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Motherboard extends BasePCComponent {
    @NotNull
    @Enumerated(EnumType.STRING)
    private Chipset chipset;

    @Override
    public String toString() {
        return getDisplayName();
    }
}
