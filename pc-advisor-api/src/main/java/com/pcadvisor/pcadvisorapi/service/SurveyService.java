package com.pcadvisor.pcadvisorapi.service;

import com.pcadvisor.pcadvisorapi.dto.SurveyDTO;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    @Autowired
    private KieContainer kieContainer;

    public SurveyDTO getCompatibility(SurveyDTO surveyDTO) {
        KieSession session = kieContainer.newKieSession("rulesSession");
        session.insert(surveyDTO);
        session.fireAllRules();
        session.dispose();
        return surveyDTO;
    }
}
