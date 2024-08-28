package com.librarian.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.model.Reservation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.typeMap(ReservationSaveRequestDto.class, Reservation.class)
                .addMappings(mapper -> {
                    mapper.map(ReservationSaveRequestDto::getBookId, Reservation::setBook);
                    mapper.map(ReservationSaveRequestDto::getMemberId, Reservation::setMember);
                });

        return modelMapper;
    }


}
