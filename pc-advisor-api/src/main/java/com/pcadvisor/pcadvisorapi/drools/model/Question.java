package com.pcadvisor.pcadvisorapi.drools.model;

import com.pcadvisor.pcadvisorapi.model.UsageArea;

import lombok.Data;

@Data
public class Question {

  private Long id;

  private String question;

  private Integer score;

  private UsageArea usageArea;
}
