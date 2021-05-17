package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.dto.SurveyDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.model.PCBuild;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;
import com.pcadvisor.pcadvisorapi.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<SurveyDTO> submitSurvey(@RequestBody SurveyDTO surveyDTO) {
        //CPU cpu = cpuRepository.findCPUByDisplayName(surveyDTO.getCpuName());
        //Motherboard motherboard = motherboardRepository.findMotherboardByDisplayName(surveyDTO.getMotherboardName());

        //System.out.println(surveyDTO.getCpuName());
        //System.out.println(surveyDTO.getMotherboardName());

        surveyDTO = surveyService.getCompatibility(surveyDTO);

        return new ResponseEntity<SurveyDTO>(surveyDTO, HttpStatus.OK);
    }
}
