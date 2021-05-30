package com.pcadvisor.pcadvisorapi.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@MappedSuperclass
@Data
public class BasePCComponent extends BaseEntity {
    @NotBlank
    @Size(min = 3, max = 64)
    @Column(nullable = false)
    private String displayName;

    @NotNull
    private Float price; // in Euros

    @Override
    public String toString() {
        return getDisplayName();
    }
}
