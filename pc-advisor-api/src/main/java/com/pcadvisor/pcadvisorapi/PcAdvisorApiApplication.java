package com.pcadvisor.pcadvisorapi;

import com.pcadvisor.pcadvisorapi.model.PCBuild;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PcAdvisorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PcAdvisorApiApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}
}
