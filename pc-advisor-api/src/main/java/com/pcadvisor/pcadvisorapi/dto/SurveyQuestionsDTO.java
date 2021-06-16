package com.pcadvisor.pcadvisorapi.dto;

import java.util.Set;

import lombok.Data;

@Data
public class SurveyQuestionsDTO {

  private Set<SurveyQuestionRequestDTO> questions;
}
