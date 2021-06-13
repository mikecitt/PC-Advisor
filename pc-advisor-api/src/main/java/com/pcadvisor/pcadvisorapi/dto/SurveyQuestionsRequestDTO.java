package com.pcadvisor.pcadvisorapi.dto;

import java.util.Set;

import lombok.Data;

@Data
public class SurveyQuestionsRequestDTO {

  private Set<QuestionRequestDTO> questions;
}
