package com.pcadvisor.pcadvisorapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.kie.api.definition.type.Position;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class CPU extends BasePCComponentPowered {
    @Position(0)
    @Enumerated(EnumType.STRING)
    @NotNull
    private CPUBrand cpuBrand;
    @Position(1)
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

    @Override
    public String toString() {
        return getDisplayName();
    }
}
