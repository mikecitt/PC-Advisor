package com.pcadvisor.pcadvisorapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@Data
public class BasePCComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 64)
    @Column(nullable = false)
    private String displayName;

    @NotNull
    private Float price; // in Euros
}
