package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class RAM extends BasePCComponent {
    @Enumerated(EnumType.STRING)
    @NotNull
    private RamType ramType;
    @NotNull
    private Integer size; // in GigaBytes

    @Override
    public String toString() {
        return getDisplayName();
    }
}
