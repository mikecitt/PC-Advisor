package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class PowerSupply extends BasePCComponent {
    @NotNull
    private Integer wattage; // in Watts
}
