package com.pcadvisor.pcadvisorapi.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CompatibilityRequestDTO {

	@NotNull
	private Long cpuId;

	@NotNull
	private Long motherboardId;
}
