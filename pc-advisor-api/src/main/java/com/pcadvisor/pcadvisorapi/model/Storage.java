package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

enum StorageType {
    SSD,
    HDD
}

@Data
public class Storage extends BasePCComponent {
    private StorageType type;
    private Integer size; // in GigaBytes
}
