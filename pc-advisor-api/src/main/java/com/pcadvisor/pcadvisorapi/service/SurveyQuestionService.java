package com.pcadvisor.pcadvisorapi.service;

import java.util.List;

import com.pcadvisor.pcadvisorapi.model.SurveyQuestion;
import com.pcadvisor.pcadvisorapi.repository.SurveyQuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyQuestionService {

  @Autowired
  public SurveyQuestionRepository surveyQuestionRepository;

  public List<SurveyQuestion> findAll() {
    return surveyQuestionRepository.findAll();
  }
}
