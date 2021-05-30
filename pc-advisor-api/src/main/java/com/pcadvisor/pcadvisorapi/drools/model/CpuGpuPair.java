package com.pcadvisor.pcadvisorapi.drools.model;

import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.GPU;

import lombok.Data;

@Data
public class CpuGpuPair {
    private CPU cpu;
    private GPU gpu;

    public CpuGpuPair(CPU cpu, GPU gpu) {
        this.cpu = cpu;
        this.gpu = gpu;
    }
}
