package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

enum RamType {
    SINGLE,
    KIT
}

@Data
@Entity
public class RAM extends BasePCComponent {
    @Enumerated(EnumType.STRING)
    @NotNull
    private RamType ramType;
    @NotNull
    private Integer size; // in GigaBytes
}
