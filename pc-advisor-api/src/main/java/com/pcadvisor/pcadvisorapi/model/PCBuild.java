package com.pcadvisor.pcadvisorapi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PCBuild {
    private CPU cpu;
    private GPU gpu;
    private Motherboard motherboard;
    private PowerSupply powerSupply;
    private RAM ram;
    private List<Storage> storage = new ArrayList<Storage>();

    public PCBuild(CPU cpu, Motherboard motherboard, GPU gpu) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.gpu = gpu;
    }

    public Float getPrice() {
        return (cpu == null ? 0 : cpu.getPrice()) + (gpu == null ? 0 : gpu.getPrice()) + (motherboard == null ? 0 : motherboard.getPrice()) + (powerSupply == null ? 0 : powerSupply.getPrice()) + (ram == null ? 0 : ram.getPrice());
    } 

    public Integer getPowerUsage() {
        return (cpu == null ? 0 : cpu.getTDP()) + (gpu == null ? 0 : gpu.getTDP());
    }

    @Override
    public String toString() {
        return "****************\n" +
            "CPU: " + getCpu() + "\n" +
            "GPU: " + getGpu() + "\n" +
            " MB: " + getMotherboard() + "\n" +
            "PSU: " + getPowerSupply() + "\n" +
            "RAM: " + getRam() + "\n" +
            "SSD: " + getStorage() + "\n" +
            "Total price: " + getPrice();
    }

    public PCBuild(PCBuild pcBuild) {
        this.cpu = pcBuild.getCpu();
        this.gpu = pcBuild.getGpu();
        this.motherboard = pcBuild.getMotherboard();
        this.powerSupply = pcBuild.getPowerSupply();
        this.ram = pcBuild.getRam();
        this.storage = pcBuild.getStorage();
    }
}
