package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

enum StorageType {
    SSD,
    HDD
}

@Data
@Entity
public class Storage extends BasePCComponent {
    @Enumerated(EnumType.STRING)
    @NotNull
    private StorageType type;
    @NotNull
    private Integer size; // in GigaBytes
}
