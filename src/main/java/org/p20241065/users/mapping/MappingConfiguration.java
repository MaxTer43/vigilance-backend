package org.p20241065.users.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("userMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
}
