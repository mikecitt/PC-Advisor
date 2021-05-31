package com.pcadvisor.pcadvisorapi;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PcAdvisorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PcAdvisorApiApplication.class, args);
    }

    @Bean
    public KieContainer getKieContainerInstance() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks
                .newKieContainer(ks.newReleaseId("org.pcadvisorkjar", "pc-advisor-kjar", "1.0-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        // kScanner.start(10_000);

        return kContainer;
    }

    /*
     * @Bean public void makeRulesFromTemplate() throws IOException { InputStream
     * template = PcAdvisorApiApplication.class.getResourceAsStream(
     * "./QuestionRuleTemplate.drl");
     * 
     * DataProvider dataProvider = new ArrayDataProvider( new String[][] { new
     * String[] { "1" }, new String[] { "3" }, new String[] { "4" }, new String[] {
     * "5" }, new String[] { "7" }, new String[] { "9" }, new String[] { "10" } });
     * 
     * DataProviderCompiler converter = new DataProviderCompiler(); String drl =
     * converter.compile(dataProvider, template); System.out.println(drl);
     * 
     * BufferedWriter writer = new BufferedWriter(new
     * FileWriter("./QuestionRules.txt")); writer.write(drl); writer.flush();
     * writer.close(); }
     */
}
