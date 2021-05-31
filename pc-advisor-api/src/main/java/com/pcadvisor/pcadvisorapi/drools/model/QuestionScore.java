package com.pcadvisor.pcadvisorapi.drools.model;

import java.util.HashMap;
import java.util.Map;

import com.pcadvisor.pcadvisorapi.model.UsageArea;

import lombok.Data;

@Data
public class QuestionScore {

  private Map<UsageArea, Integer> scores;

  public QuestionScore() {
    scores = new HashMap<>();

    scores.put(UsageArea.GAMING, 0);
    scores.put(UsageArea.GRAPHIC_DESIGN, 0);
    scores.put(UsageArea.MODELING_3D, 0);
    scores.put(UsageArea.OFFICE, 0);
    scores.put(UsageArea.PROGRAMMING, 0);
  }
}
