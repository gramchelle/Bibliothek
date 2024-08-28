package com.librarian.configuration;
/*
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.model.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(ReservationSaveRequestDto.class, Reservation.class).addMappings(mapper -> {
            mapper.map(ReservationSaveRequestDto::getBookId, Reservation::setBookId);
            mapper.map(ReservationSaveRequestDto::getMemberId, Reservation::setMemberId);
        });
        return modelMapper;
    }
}
*/