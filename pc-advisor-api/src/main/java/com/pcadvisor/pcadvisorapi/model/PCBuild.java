package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import java.util.List;

@Data
public class PCBuild {

    private CPU cpu;
    private GPU gpu;
    private Motherboard motherboard;
    private PowerSupply powerSupply;
    private RAM ram;
    private List<Storage> storage;
}