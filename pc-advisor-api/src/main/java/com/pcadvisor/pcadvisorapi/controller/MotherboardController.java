package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/mb")
public class MotherboardController {
    @Autowired
    private MotherboardRepository motherboardRepository;

    @GetMapping
    List<Motherboard> getAll() {
        return motherboardRepository.findAll();
    }
}
