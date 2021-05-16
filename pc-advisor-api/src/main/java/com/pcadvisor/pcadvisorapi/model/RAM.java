package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

enum RamType {
    SINGLE,
    KIT
}

@Data
public class RAM extends BasePCComponent {
    private RamType ramType;
    private Integer size; // in GigaBytes
}
