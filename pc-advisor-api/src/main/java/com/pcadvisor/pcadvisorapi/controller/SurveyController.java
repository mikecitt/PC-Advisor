package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.dto.UsageAreasDTO;
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
    private SurveyService surveyService;

    @PostMapping("/usageArea")
    public ResponseEntity<ComputerProgramsDTO> submitUsageArea(@RequestBody UsageAreasDTO request) {
        return new ResponseEntity<>(surveyService.submitUsageArea(request), HttpStatus.OK);
    }

    @PostMapping("programs")
    public ResponseEntity<PriorityDTO> submitComputerPrograms(@RequestBody ComputerProgramsDTO request) {
        return new ResponseEntity<>(surveyService.submitComputerPrograms(request), HttpStatus.OK);
    }
}
