package com.pcadvisor.pcadvisorapi.controller;

import java.util.List;

import com.pcadvisor.pcadvisorapi.dto.CompatibilityRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.CompatibilityResponseDTO;
import com.pcadvisor.pcadvisorapi.dto.FindAllMotherboardsRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.SearchRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.SearchResponseDTO;
import com.pcadvisor.pcadvisorapi.model.Motherboard;
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
    public ResponseEntity<CompatibilityResponseDTO> check(@RequestBody CompatibilityRequestDTO request) {
        return new ResponseEntity<>(compatibilityService.check(request), HttpStatus.OK);
    }

    @PostMapping("/find-motherboards")
    public ResponseEntity<List<Motherboard>> findAllMotherboards(@RequestBody FindAllMotherboardsRequestDTO request) {
        return new ResponseEntity<>(compatibilityService.findAllMotherboards(request), HttpStatus.OK);
    }

    @PostMapping("/check-same-cores")
    public ResponseEntity<SearchResponseDTO> checkSameCores(@RequestBody SearchRequestDTO request) {
        return new ResponseEntity<>(compatibilityService.checkSameCores(request), HttpStatus.OK);
    }
}
