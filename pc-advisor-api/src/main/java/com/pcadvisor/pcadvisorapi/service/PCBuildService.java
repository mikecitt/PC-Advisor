package com.pcadvisor.pcadvisorapi.service;

import java.util.List;

import com.pcadvisor.pcadvisorapi.drools.model.CpuGpuPair;
import com.pcadvisor.pcadvisorapi.drools.model.CpusGpus;
import com.pcadvisor.pcadvisorapi.dto.AffinitiesDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.GPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.model.PowerSupply;
import com.pcadvisor.pcadvisorapi.model.RAM;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;
import com.pcadvisor.pcadvisorapi.repository.GPURepository;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;
import com.pcadvisor.pcadvisorapi.repository.PowerSupplyRepository;
import com.pcadvisor.pcadvisorapi.repository.RAMRepository;

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

    @Autowired
    private RAMRepository ramRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private PowerSupplyRepository powerSupplyRepository;

    public CpusGpus getCpuGpuPairs(PriorityDTO priorityDTO, AffinitiesDTO affinitiesDTO) {
        KieSession session = kieContainer.newKieSession("rulesSession");
        List<CPU> cpus = cpuRepository.findAll();
        List<GPU> gpus = gpuRepository.findAll();
        List<RAM> rams = ramRepository.findAll();
        List<Motherboard> motherboards = motherboardRepository.findAll();
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        session.insert(priorityDTO);
        session.insert(affinitiesDTO);
        for(CPU cpu : cpus)
            session.insert(cpu);
        for(GPU gpu: gpus)
            session.insert(gpu);
        for(RAM ram: rams)
            session.insert(ram);
        for(Motherboard motherboard: motherboards)
            session.insert(motherboard);
        for(PowerSupply powerSupply: powerSupplies)
            session.insert(powerSupply);
        CpuGpuPair pair = new CpuGpuPair();
        CpusGpus cpusGpus = new CpusGpus();
        //session.insert(pair);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        System.out.println("GOTOVOO *****");
        session.getAgenda().getAgendaGroup("finish").setFocus();
        session.fireAllRules();
        session.dispose();
        return cpusGpus;
    }
}
