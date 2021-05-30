package com.pcadvisor.pcadvisorapi.service;

import com.pcadvisor.pcadvisorapi.drools.model.CpuGpuPair;
import com.pcadvisor.pcadvisorapi.dto.AffinitiesDTO;
import com.pcadvisor.pcadvisorapi.dto.PriorityDTO;

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
        PriorityDTO priorityDTO = new PriorityDTO(5, 5, 5);
        AffinitiesDTO affinitiesDTO = new AffinitiesDTO("AMD", 450, 1000);
        //CpusGpus cpusGpus = pcBuildService.getCpuGpuPairs(priorityDTO);
        pcBuildService.getCpuGpuPairs(priorityDTO, affinitiesDTO);
        CpuGpuPair pair = new CpuGpuPair();
        /*for(CPU cpu: cpusGpus.getCpus()) {
            Assert.assertTrue(cpu.getScore() > (priorityDTO.getCpuPriority() * 9000 / 10));
        }
        for(GPU gpu: cpusGpus.getGpus()) {
            Assert.assertTrue(gpu.getScore() > (priorityDTO.getGpuPriority() * 20000 / 10));
        }*/
    }
}
