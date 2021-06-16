package com.pcadvisor.pcadvisorapi.drools.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pcadvisor.pcadvisorapi.model.UsageArea;

import lombok.Data;

@Data
public class SurveyQuestionScores {

  private Map<UsageArea, Integer> scores;

  public SurveyQuestionScores() {
    scores = new HashMap<>();

    scores.put(UsageArea.GAMING, 0);
    scores.put(UsageArea.GRAPHIC_DESIGN, 0);
    scores.put(UsageArea.MODELING_3D, 0);
    scores.put(UsageArea.OFFICE, 0);
    scores.put(UsageArea.PROGRAMMING, 0);
  }

  public List<UsageArea> getBest() {
    Map<UsageArea, Integer> top = scores.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(2)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    System.out.println(top);
    return new ArrayList<UsageArea>(top.keySet());
  }
}
