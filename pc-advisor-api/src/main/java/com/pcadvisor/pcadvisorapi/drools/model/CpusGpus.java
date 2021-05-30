package com.pcadvisor.pcadvisorapi.drools.model;

import java.util.ArrayList;
import java.util.List;

import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.GPU;

public class CpusGpus {
    private List<CPU> cpus;
    private List<GPU> gpus;

    public CpusGpus() {
        cpus = new ArrayList<>();
        gpus = new ArrayList<>();
    }

    public void addCpu(CPU cpu) {
        cpus.add(cpu);
    }

    public void addGpu(GPU gpu) {
        gpus.add(gpu);
    }

    public List<CPU> getCpus() {
        return cpus;
    }

    public List<GPU> getGpus() {
        return gpus;
    }
}
