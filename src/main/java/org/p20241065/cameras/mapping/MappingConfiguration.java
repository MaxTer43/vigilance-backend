package org.p20241065.cameras.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("cameraMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public CameraMapper cameraMapper(){
        return new CameraMapper();
    }
}
