package com.pcadvisor.pcadvisorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AffinitiesDTO {
    private String brandPref;
    private Integer storageMin;
    private Integer budget;
}
