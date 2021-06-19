package com.pcadvisor.pcadvisorapi.controller;

import java.util.List;

import com.pcadvisor.pcadvisorapi.model.SurveyQuestion;
import com.pcadvisor.pcadvisorapi.service.SurveyQuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey-question")
public class SurveyQuestionController {

  @Autowired
  private SurveyQuestionService surveyQuestionService;

  @GetMapping
  public List<SurveyQuestion> getAll() {
    return surveyQuestionService.findAll();
  }
}
