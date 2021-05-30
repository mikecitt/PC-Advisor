package com.pcadvisor.pcadvisorapi.service;

import com.pcadvisor.pcadvisorapi.drools.model.CpusGpus;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;
import com.pcadvisor.pcadvisorapi.model.CPU;
import com.pcadvisor.pcadvisorapi.model.GPU;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PCBuildServiceUnitTests {
    @Autowired
    private PCBuildService pcBuildService;

    @Test
    public void testGetCpusGpus() {
        PriorityDTO priorityDTO = new PriorityDTO(5, 5, 4);
        CpusGpus cpusGpus = pcBuildService.getCpuGpuPairs(priorityDTO);
        for(CPU cpu: cpusGpus.getCpus()) {
            Assert.assertTrue(cpu.getScore() > (priorityDTO.getCpuPriority() * 9000 / 10));
        }
        for(GPU gpu: cpusGpus.getGpus()) {
            Assert.assertTrue(gpu.getScore() > (priorityDTO.getGpuPriority() * 20000 / 10));
        }
    }
}
