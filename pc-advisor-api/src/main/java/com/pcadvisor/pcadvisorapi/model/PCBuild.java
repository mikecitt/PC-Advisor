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

    public PCBuild(CPU cpu, GPU gpu) {
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public Float getPrice() {
        return (cpu == null ? 0 : cpu.getPrice()) + (gpu == null ? 0 : gpu.getPrice()) + (motherboard == null ? 0 : motherboard.getPrice()) + (powerSupply == null ? 0 : powerSupply.getPrice()) + (ram == null ? 0 : ram.getPrice());
    } 

    @Override
    public String toString() {
        return "{" +
            " cpu='" + getCpu() + "'" +
            ", gpu='" + getGpu() + "'" +
            ", motherboard='" + getMotherboard() + "'" +
            ", powerSupply='" + getPowerSupply() + "'" +
            ", ram='" + getRam() + "'" +
            ", storage='" + getStorage() + "'" +
            ", price='" + getPrice() +"'}";
    }
}
