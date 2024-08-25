package com.librarian.dto.responseDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationGetAllResponseDto {
    private Long id;
    private Long member_id;
    private String title;
    private LocalDate reservationDate;
    private LocalDate dueDate;
}
