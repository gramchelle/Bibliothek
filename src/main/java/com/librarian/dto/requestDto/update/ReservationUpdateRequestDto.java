package com.librarian.dto.requestDto.update;

import com.librarian.model.LoanStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationUpdateRequestDto {

    private Long id;
    private LocalDate reservationDate; // Bu alanı ekleyin
    private LoanStatus status; // Bu alanı enum olarak ayarlayın
}
