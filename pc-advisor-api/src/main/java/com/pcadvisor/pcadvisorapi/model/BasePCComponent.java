package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

@Data
public class BasePCComponent {
    private String displayName;
    private Float price; // in Euros
}
