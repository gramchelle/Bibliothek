package com.librarian.dto.requestDto.update;

import com.librarian.model.LoanStatus;
import com.librarian.model.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationUpdateRequestDto {

    private Long id;
    private LocalDate reservationDate;
    private String status;
}
