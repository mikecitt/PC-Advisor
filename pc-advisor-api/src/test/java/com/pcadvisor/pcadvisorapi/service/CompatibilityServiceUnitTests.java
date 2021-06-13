package com.pcadvisor.pcadvisorapi.service;

import javax.transaction.Transactional;

import com.pcadvisor.pcadvisorapi.dto.CompatibilityRequestDTO;
import com.pcadvisor.pcadvisorapi.dto.CompatibilityResponseDTO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompatibilityServiceUnitTests {

  @Autowired
  private CompatibilityService compatibilityService;

  @Test
  @Transactional
  public void testCpuMotherboardCompatibilitySuccess() {

    CompatibilityRequestDTO request = new CompatibilityRequestDTO();
    request.setCpuId(1L);
    request.setMotherboardId(1L);

    CompatibilityResponseDTO response = compatibilityService.checkCompatibility(request);
    Assert.assertTrue(response.isSuccess());
  }

  @Test
  @Transactional
  public void testCpuMotherboardCompatibilityFail() {

    CompatibilityRequestDTO request = new CompatibilityRequestDTO();
    request.setCpuId(1L);
    request.setMotherboardId(4L);

    CompatibilityResponseDTO response = compatibilityService.checkCompatibility(request);
    Assert.assertFalse(response.isSuccess());
  }
}
