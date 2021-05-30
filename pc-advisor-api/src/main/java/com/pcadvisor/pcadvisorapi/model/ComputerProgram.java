package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class ComputerProgram extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 64)
    private String displayName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UsageArea usageArea;
}
