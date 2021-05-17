package com.pcadvisor.pcadvisorapi.service;

import com.pcadvisor.pcadvisorapi.dto.SurveyDTO;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
    private final KieContainer kieContainer;

    @Autowired
    public SurveyService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public SurveyDTO getCompatibility(SurveyDTO surveyDTO) {
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        kieSession.insert(surveyDTO);
        kieSession.fireAllRules();
        kieSession.dispose();
        return surveyDTO;
    }
}
