package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

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
