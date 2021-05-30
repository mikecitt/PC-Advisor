package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class ComputerProgram extends BaseEntity {

    private String name;

    private UsageArea usageArea;
}
