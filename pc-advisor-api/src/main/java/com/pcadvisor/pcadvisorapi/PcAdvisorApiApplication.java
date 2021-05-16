package com.pcadvisor.pcadvisorapi;

import com.pcadvisor.pcadvisorapi.model.PCBuild;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PcAdvisorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcAdvisorApiApplication.class, args);
	}

}
