package com.pcadvisor.pcadvisorapi.service;

import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.dto.UsageAreasDTO;
import com.pcadvisor.pcadvisorapi.model.ComputerProgram;
import com.pcadvisor.pcadvisorapi.repository.ComputerProgramRepository;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SurveyService {

  @Autowired
  private KieContainer kieContainer;

  @Autowired
  private ComputerProgramRepository computerProgramRepository;

  public ComputerProgramsDTO submitUsageArea(@RequestBody UsageAreasDTO request) {

    ComputerProgramsDTO response = new ComputerProgramsDTO();

    KieSession session = kieContainer.newKieSession("rulesSession");
    session.insert(request);
    session.insert(response);
    for (ComputerProgram program : computerProgramRepository.findAll()) {
      session.insert(program);
    }
    session.fireAllRules();
    session.dispose();

    return response;
  }

  public PriorityDTO submitComputerPrograms(@RequestBody ComputerProgramsDTO request) {

    PriorityDTO response = new PriorityDTO(0, 0, 0);

    KieSession session = kieContainer.newKieSession("rulesSession");
    session.insert(response);
    for (ComputerProgram program : request.getComputerPrograms()) {
      session.insert(program);
    }
    session.fireAllRules();
    session.dispose();

    return response;
  }
}
