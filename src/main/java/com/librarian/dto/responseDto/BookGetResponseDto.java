package com.librarian.dto.responseDto;


import lombok.*;
import java.util.UUID;

@Getter
@Setter
public class BookGetResponseDto {

    private long id;
    private UUID isbn;
    private String title;
    private String author;
    private int publicationYear;
    private String category;

}
