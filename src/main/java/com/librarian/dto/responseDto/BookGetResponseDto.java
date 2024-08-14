package com.librarian.dto.responseDto;

import com.librarian.dto.requestDto.save.BookSaveRequestDto;
import com.librarian.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDate;
import java.util.UUID;

public class BookGetResponseDto {

    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    private UUID isbn;
    private String title;
    private String author;
    private LocalDate publicationYear;
    private String category;

}
