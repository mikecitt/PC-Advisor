package com.pcadvisor.pcadvisorapi.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.pcadvisor.pcadvisorapi.dto.AffinitiesDTO;
import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.ComputerProgramsResponseDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.dto.SurveyQuestionsDTO;
import com.pcadvisor.pcadvisorapi.dto.UsageAreasDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.GPU;
import com.pcadvisor.pcadvisorapi.model.Motherboard;
import com.pcadvisor.pcadvisorapi.model.PCBuild;
import com.pcadvisor.pcadvisorapi.model.PowerSupply;
import com.pcadvisor.pcadvisorapi.model.RAM;
import com.pcadvisor.pcadvisorapi.model.Storage;
import com.pcadvisor.pcadvisorapi.repository.CPURepository;
import com.pcadvisor.pcadvisorapi.repository.GPURepository;
import com.pcadvisor.pcadvisorapi.repository.MotherboardRepository;
import com.pcadvisor.pcadvisorapi.repository.PowerSupplyRepository;
import com.pcadvisor.pcadvisorapi.repository.RAMRepository;
import com.pcadvisor.pcadvisorapi.repository.StorageRepository;
import com.pcadvisor.pcadvisorapi.service.SurveyService;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
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

    @Autowired
    private CPURepository cpuRepository;

    @Autowired
    private GPURepository gpuRepository;

    @Autowired
    private PowerSupplyRepository powerSupplyRepository;

    @Autowired
    private MotherboardRepository motherboardRepository;

    @Autowired
    private RAMRepository ramRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private KieContainer kieContainer;

    @PostMapping("/submitQuestions")
    public ResponseEntity<ComputerProgramsResponseDTO> submitQuestions(@RequestBody SurveyQuestionsDTO request) {
        return new ResponseEntity<>(surveyService.submitQuestions(request), HttpStatus.OK);
    }

    @PostMapping("/usageArea")
    public ResponseEntity<ComputerProgramsResponseDTO> submitUsageArea(@RequestBody UsageAreasDTO request) {
        return new ResponseEntity<>(surveyService.submitUsageArea(request), HttpStatus.OK);
    }

    @PostMapping("/submitPrograms")
    public ResponseEntity<PriorityDTO> submitComputerPrograms(@RequestBody ComputerProgramsRequestDTO request) {
        return new ResponseEntity<>(surveyService.submitComputerPrograms(request), HttpStatus.OK);
    }

    @PostMapping("/submitSurvey")
    public ResponseEntity<Collection<?>> submitSurvey() {
        KieSession session = kieContainer.newKieSession("rulesSession");

        PriorityDTO priorityDTO = new PriorityDTO(5, 5, 5);
        AffinitiesDTO affinitiesDTO = new AffinitiesDTO(null, null, 900);
        List<CPU> cpus = cpuRepository.findAll();
        List<GPU> gpus = gpuRepository.findAll();
        List<RAM> rams = ramRepository.findAll();
        List<Storage> storages = storageRepository.findAll();
        List<Motherboard> motherboards = motherboardRepository.findAll();
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        session.insert(priorityDTO);
        session.insert(affinitiesDTO);
        for (CPU cpu : cpus)
            session.insert(cpu);
        for (GPU gpu : gpus)
            session.insert(gpu);
        for (RAM ram : rams)
            session.insert(ram);
        for (Storage storage : storages)
            session.insert(storage);
        for (Motherboard motherboard : motherboards)
            session.insert(motherboard);
        for (PowerSupply powerSupply : powerSupplies)
            session.insert(powerSupply);
        session.getAgenda().getAgendaGroup("cpu-gpu-ram").setFocus();
        session.fireAllRules();
        session.getAgenda().getAgendaGroup("finish").setFocus();
        session.fireAllRules();

        ObjectFilter pcBuildFilter = new ObjectFilter() {

            @Override
            public boolean accept(Object object) {
                if (PCBuild.class.equals(object.getClass()))
                    return true;
                if (PCBuild.class.equals(object.getClass().getSuperclass()))
                    return true;
                return false;
            }
        };
        Collection<?> objects = session.getObjects(pcBuildFilter);

        session.dispose();
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }
}
