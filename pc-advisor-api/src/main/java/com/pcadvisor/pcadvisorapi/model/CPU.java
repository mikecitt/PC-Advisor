package com.pcadvisor.pcadvisorapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import lombok.Data;

enum CPUBrand {
    AMD,
    INTEL
}

@Data
@Entity
public class CPU extends BasePCComponentPowered {
    @Enumerated(EnumType.STRING)
    @NotNull
    private CPUBrand cpuBrand;
    @NotNull
    private Integer cores;
    @NotNull
    private Float frequency;
    @NotNull
    private Integer score; // 3DMark Physics Score 

    @Column
    @ElementCollection(targetClass = Chipset.class)
    @Enumerated(EnumType.STRING)
    private List<Chipset> compatibleChipsets;
}
