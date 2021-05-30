package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.dto.request.CompatibilityRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.response.CompatibilityResponseDTO;
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

    @PostMapping("/check")
    public ResponseEntity<CompatibilityResponseDTO> checkCompatibility(@RequestBody CompatibilityRequestDTO request) {
        return new ResponseEntity<>(compatibilityService.checkCompatibility(request), HttpStatus.OK);
    }
}
