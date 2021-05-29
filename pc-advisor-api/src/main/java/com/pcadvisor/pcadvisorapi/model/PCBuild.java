package com.pcadvisor.pcadvisorapi.model;

import java.util.List;

import lombok.Data;

@Data
public class PCBuild {
    private CPU cpu;
    private GPU gpu;
    private Motherboard motherboard;
    private PowerSupply powerSupply;
    private RAM ram;
    private List<Storage> storage;

    public PCBuild(CPU cpu, Motherboard motherboard) {
        this.cpu = cpu;
        this.motherboard = motherboard;
    }
}
