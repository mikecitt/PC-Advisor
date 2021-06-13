package com.pcadvisor.pcadvisorapi.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class QuestionRequestDTO {

  @NotNull
  private Long id;

  @NotNull
  private Integer score;
}
