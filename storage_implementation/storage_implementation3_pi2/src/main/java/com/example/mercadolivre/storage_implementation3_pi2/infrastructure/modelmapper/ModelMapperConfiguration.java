package com.example.mercadolivre.storage_implementation3_pi2.infrastructure.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }
}
