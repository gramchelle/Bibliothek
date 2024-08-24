package com.librarian.dto.responseDto;

import com.librarian.dto.requestDto.save.BookSaveRequestDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationGetResponseDto {
    private Long id;
    private LocalDate reservationDate;
    private BookSaveRequestDto book;

}
