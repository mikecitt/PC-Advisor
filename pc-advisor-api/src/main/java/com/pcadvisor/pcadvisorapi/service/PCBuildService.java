package com.pcadvisor.pcadvisorapi.service;

import java.util.List;

import com.pcadvisor.pcadvisorapi.drools.model.CpusGpus;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.GPU;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;
import com.pcadvisor.pcadvisorapi.repository.GPURepository;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PCBuildService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    public CpusGpus getCpuGpuPairs(PriorityDTO priorityDTO) {
        KieSession session = kieContainer.newKieSession("rulesSession");
        List<CPU> cpus = cpuRepository.findAll();
        List<GPU> gpus = gpuRepository.findAll();
        session.insert(priorityDTO);
        for(CPU cpu : cpus)
            session.insert(cpu);
        for(GPU gpu: gpus)
            session.insert(gpu);
        CpusGpus cpusGpus = new CpusGpus();
        session.insert(cpusGpus);
        session.fireAllRules();
        session.dispose();
        return cpusGpus;
    }
}
