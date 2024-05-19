package org.p20241065.reports.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("reportMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ReportMapper reportMapper(){
        return new ReportMapper();
    }
}
