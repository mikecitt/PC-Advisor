package com.pcadvisor.pcadvisorapi.service;

import java.util.List;

import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private CPURepository cpuRepository;

    public List<CPU> getCompatibility(PriorityDTO priorityDTO) {
        KieSession session = kieContainer.newKieSession("rulesSession");
        List<CPU> cpus = cpuRepository.findAll();
        session.insert(priorityDTO);
        for(CPU cpu : cpus)
            session.insert(cpu);
        session.fireAllRules();
        session.dispose();
        return cpus;
    }
}
