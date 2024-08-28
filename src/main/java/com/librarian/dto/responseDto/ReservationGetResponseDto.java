package com.librarian.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationGetResponseDto {

    private Long id;
    private LocalDate reservationDate;
    private LocalDate dueDate;
    private String title;
}
