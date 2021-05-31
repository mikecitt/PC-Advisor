package com.pcadvisor.pcadvisorapi.dto;

import com.pcadvisor.pcadvisorapi.model.CPUBrand;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AffinitiesDTO {
    private CPUBrand brandPref;
    private Integer storageMin;
    private Integer budget;

    public AffinitiesDTO() {
        
    }
}
