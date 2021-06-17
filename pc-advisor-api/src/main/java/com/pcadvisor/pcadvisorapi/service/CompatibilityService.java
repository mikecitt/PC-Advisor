package com.pcadvisor.pcadvisorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pcadvisor.pcadvisorapi.dto.FindAllMotherboardsRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.CompatibilityRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.CompatibilityResponseDTO;
import com.pcadvisor.pcadvisorapi.exception.CPUNotFoundException;
import com.pcadvisor.pcadvisorapi.exception.MotherboardNotFoundException;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
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
    session.getAgenda().getAgendaGroup("checkCompatibility").setFocus();
    session.fireAllRules();
    session.dispose();
    return response;
  }

  public List<Motherboard> findAllMotherboards(FindAllMotherboardsRequestDTO request) {

    KieSession session = kieContainer.newKieSession("rulesSession");
    for (Motherboard motherboard : motherboardService.findAll()) {
      session.insert(motherboard);
    }

    Optional<CPU> cpu = cpuService.findById(request.getCpuId());

    if (cpu.isEmpty()) {
      throw new CPUNotFoundException("CPU with given id not found");
    }

    QueryResults results = session.getQueryResults("Find all motherboards for CPU", cpu.get());

    List<Motherboard> motherboards = new ArrayList<Motherboard>();

    for (QueryResultsRow quesryResult : results) {
      Motherboard motherboard = (Motherboard) quesryResult.get("$motherboard");
      motherboards.add(motherboard);
    }

    // session.fireAllRules();

    session.dispose();
    return motherboards;
  }
}
