package com.librarian.dto.requestDto.save;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class BookSaveRequestDto {

    private UUID isbn;
    private String title;
    private String author;
    private int publicationYear;
    private String category;
}
