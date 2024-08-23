package com.librarian.dto.requestDto.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequestDto {

    private String title;
    private String author;
    private String category;

}
