package com.librarian.dto.requestDto.save;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationSaveRequestDto {

    private Long bookId;
    private Long memberId;
    private LocalDate reservationDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
}
