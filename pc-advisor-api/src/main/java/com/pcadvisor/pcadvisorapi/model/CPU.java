package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

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

    @Column
    @ElementCollection(targetClass = Chipset.class)
    @Enumerated(EnumType.STRING)
    private List<Chipset> compatibleChipsets;
}
