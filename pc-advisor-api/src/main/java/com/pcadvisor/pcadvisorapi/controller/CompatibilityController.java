package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.dto.CompatibilityRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.CompatibilityResponseDTO;
import com.pcadvisor.pcadvisorapi.service.CompatibilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityController {

    @Autowired
    private CompatibilityService compatibilityService;

    @PostMapping
    public ResponseEntity<CompatibilityResponseDTO> check(@RequestBody CompatibilityRequestDTO request) {
        return new ResponseEntity<>(compatibilityService.check(request), HttpStatus.OK);
    }
}
