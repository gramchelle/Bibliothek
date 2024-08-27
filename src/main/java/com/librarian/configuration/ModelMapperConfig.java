package com.librarian.configuration;
/*
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.model.Book;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<ReservationSaveRequestDto, Reservation>() {
            @Override
            protected void configure() {
                // Map bookId to Book entity
                map().setBook(source.getBookId() != null ? new Book(source.getBookId()) : null);
                // Map memberId to Member entity
                map().setMember(source.getMemberId() != null ? new Member(source.getMemberId()) : null);
            }
        });

        return modelMapper;
    }
}
*/