package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class SurveyQuestion extends BaseEntity {

  @NotNull
  @Size(min = 16, max = 256)
  private String question;

  @NotNull
  @Enumerated(EnumType.STRING)
  private UsageArea usageArea;
}
