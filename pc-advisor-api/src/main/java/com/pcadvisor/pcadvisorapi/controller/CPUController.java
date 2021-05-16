package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cpu")
public class CPUController {
    @Autowired
    private CPURepository cpuRepository;

    @GetMapping
    List<CPU> getAll() {
        return cpuRepository.findAll();
    }
}
