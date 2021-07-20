package com.example.dtoex.config;

import com.example.dtoex.model.dto.GameAddDto;
import com.example.dtoex.model.entity.Games;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(GameAddDto.class, Games.class)
                .addMappings(mapper ->
                        mapper.map(GameAddDto::getThumbnailURL, Games::setThumbnail));

        return modelMapper;
    }
}
