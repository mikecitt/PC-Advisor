package com.pcadvisor.pcadvisorapi.service;

import java.util.List;
import java.util.stream.Collectors;

import com.pcadvisor.pcadvisorapi.drools.model.SurveyQuestionScores;
import com.pcadvisor.pcadvisorapi.dto.ComputerProgramRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsResponseDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyQuestionRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyQuestionsDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyRequestDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.ComputerProgram;
import com.pcadvisor.pcadvisorapi.model.GPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.model.PCBuild;
import com.pcadvisor.pcadvisorapi.model.PowerSupply;
import com.pcadvisor.pcadvisorapi.model.RAM;
import com.pcadvisor.pcadvisorapi.model.Storage;
import com.pcadvisor.pcadvisorapi.model.SurveyQuestion;
import com.pcadvisor.pcadvisorapi.repository.GPURepository;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;
import com.pcadvisor.pcadvisorapi.repository.PowerSupplyRepository;
import com.pcadvisor.pcadvisorapi.repository.RAMRepository;
import com.pcadvisor.pcadvisorapi.repository.StorageRepository;

import org.drools.core.ObjectFilter;
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
  private ComputerProgramService computerProgramService;

  @Autowired
  private SurveyQuestionService surveyQuestionService;

  @Autowired
  private CPUService cpuService;

  @Autowired
  private GPURepository gpuRepository;

  @Autowired
  private PowerSupplyRepository powerSupplyRepository;

  @Autowired
  private MotherboardRepository motherboardRepository;

  @Autowired
  private RAMRepository ramRepository;

  @Autowired
  private StorageRepository storageRepository;

  public ComputerProgramsResponseDTO submitQuestions(@RequestBody SurveyQuestionsDTO request) {

    ComputerProgramsResponseDTO response = new ComputerProgramsResponseDTO();
    SurveyQuestionScores questionScores = new SurveyQuestionScores();

    KieSession session = kieContainer.newKieSession("rulesSession");
    for (SurveyQuestionRequestDTO question : request.getQuestions()) {
      session.insert(question);
    }
    for (SurveyQuestion question : surveyQuestionService.findAll()) {
      session.insert(question);
    }
    for (ComputerProgram program : computerProgramService.findAll()) {
      session.insert(program);
    }

    session.insert(questionScores);
    session.setGlobal("computerProgramsResponse", response);
    session.fireAllRules();
    System.out.println(questionScores);
    session.dispose();

    return response;
  }

  public List<PCBuild> submitSurvey(SurveyRequestDTO request) {

    KieSession session = kieContainer.newKieSession("rulesSession");

    PriorityDTO priorityDTO = new PriorityDTO(0, 0, 0);

    List<CPU> cpus = cpuService.findAll();
    List<GPU> gpus = gpuRepository.findAll();
    List<RAM> rams = ramRepository.findAll();
    List<Storage> storages = storageRepository.findAll();
    List<Motherboard> motherboards = motherboardRepository.findAll();
    List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
    session.insert(request.getAffinitiesDTO());
    session.insert(priorityDTO);
    for (ComputerProgramRequestDTO program : request.getComputerProgramsRequestDTO().getComputerPrograms())
      session.insert(program);
    for (CPU cpu : cpus)
      session.insert(cpu);
    for (CPU cpu : cpus)
      session.insert(cpu);
    for (GPU gpu : gpus)
      session.insert(gpu);
    for (RAM ram : rams)
      session.insert(ram);
    for (Storage storage : storages)
      session.insert(storage);
    for (Motherboard motherboard : motherboards)
      session.insert(motherboard);
    for (PowerSupply powerSupply : powerSupplies)
      session.insert(powerSupply);
    session.getAgenda().getAgendaGroup("computer-programs").setFocus();
    session.fireAllRules();
    session.getAgenda().getAgendaGroup("priorities-to-builds").setFocus();
    session.fireAllRules();
    session.dispose();
    ObjectFilter pcBuildFilter = new ObjectFilter() {

      @Override
      public boolean accept(Object object) {
        if (PCBuild.class.equals(object.getClass()))
          return true;
        if (PCBuild.class.equals(object.getClass().getSuperclass()))
          return true;
        return false;
      }
    };
    List<PCBuild> objects = session.getObjects(pcBuildFilter).stream().map((obj) -> (PCBuild) obj)
        .collect(Collectors.toList());

    return objects;
  }
}
