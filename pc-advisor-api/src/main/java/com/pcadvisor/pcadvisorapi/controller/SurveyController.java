package com.pcadvisor.pcadvisorapi.controller;

import java.util.List;

import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsResponseDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyQuestionsDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyRequestDTO;
import com.pcadvisor.pcadvisorapi.model.PCBuild;
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

    @PostMapping("/submitQuestions")
    public ResponseEntity<ComputerProgramsResponseDTO> submitQuestions(@RequestBody SurveyQuestionsDTO request) {
        return new ResponseEntity<>(surveyService.submitQuestions(request), HttpStatus.OK);
    }

    @PostMapping("/submitSurvey")
    public ResponseEntity<List<PCBuild>> submitSurvey(@RequestBody SurveyRequestDTO request) {
        return new ResponseEntity<>(surveyService.submitSurvey(request), HttpStatus.OK);
    }
}
