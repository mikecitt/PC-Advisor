package com.pcadvisor.pcadvisorapi.service;

import java.util.Optional;

import com.pcadvisor.pcadvisorapi.dto.CompatibilityRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.CompatibilityResponseDTO;
import com.pcadvisor.pcadvisorapi.exception.CPUNotFoundException;
import com.pcadvisor.pcadvisorapi.exception.MotherboardNotFoundException;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompatibilityService {
  @Autowired
  private KieContainer kieContainer;

  @Autowired
  private CPUService cpuService;

  @Autowired
  private MotherboardService motherboardService;

  public CompatibilityResponseDTO check(CompatibilityRequestDTO request) {

    Optional<CPU> cpu = cpuService.findById(request.getCpuId());
    Optional<Motherboard> motherboard = motherboardService.findById(request.getMotherboardId());

    if (cpu.isEmpty()) {
      throw new CPUNotFoundException("CPU with given id not found");
    }

    if (motherboard.isEmpty()) {
      throw new MotherboardNotFoundException("Motherboard with given id not found");
    }

    CompatibilityResponseDTO response = new CompatibilityResponseDTO();

    KieSession session = kieContainer.newKieSession("rulesSession");
    session.insert(cpu.get());
    session.insert(motherboard.get());
    session.setGlobal("compatibilityResponse", response);
    session.getAgenda().getAgendaGroup("compatibility").setFocus();
    session.fireAllRules();
    session.dispose();
    return response;
  }
}
