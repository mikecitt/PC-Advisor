package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class PowerSupply extends BasePCComponent {
    @NotNull
    private Integer wattage; // in Watts
}
