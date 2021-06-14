package com.pcadvisor.pcadvisorapi.controller;

import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.service.MotherboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/motherboard")
public class MotherboardController {
    @Autowired
    private MotherboardService motherboardService;

    @GetMapping
    List<Motherboard> getAll() {
        return motherboardService.findAll();
    }
}
