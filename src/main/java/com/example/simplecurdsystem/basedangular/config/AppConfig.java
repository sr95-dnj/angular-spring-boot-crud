package com.example.simplecurdsystem.basedangular.config;

import com.example.simplecurdsystem.basedangular.util.UuidUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UuidUtil uuidUtil(){
        return new UuidUtil();
    }


}
