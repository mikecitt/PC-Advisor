package com.pcadvisor.pcadvisorapi.service;

import com.pcadvisor.pcadvisorapi.drools.model.SurveyQuestionScores;
import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsResponseDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyQuestionRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyQuestionsDTO;
import com.pcadvisor.pcadvisorapi.dto.UsageAreasDTO;
import com.pcadvisor.pcadvisorapi.model.ComputerProgram;
import com.pcadvisor.pcadvisorapi.model.SurveyQuestion;

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

  public PriorityDTO submitComputerPrograms(@RequestBody ComputerProgramsResponseDTO request) {

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

  public ComputerProgramsResponseDTO submitUsageArea(@RequestBody UsageAreasDTO request) {

    ComputerProgramsResponseDTO response = new ComputerProgramsResponseDTO();

    KieSession session = kieContainer.newKieSession("rulesSession");
    session.insert(request);
    session.insert(response);
    for (ComputerProgram program : computerProgramService.findAll()) {
      session.insert(program);
    }
    session.fireAllRules();
    session.dispose();

    return response;
  }
}
