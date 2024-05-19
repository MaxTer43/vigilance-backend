package org.p20241065.units.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("unitMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UnitMapper unitMapper(){
        return new UnitMapper();
    }
}
