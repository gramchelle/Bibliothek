package com.librarian.dto.requestDto.save;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationSaveRequestDto {

    private Long id;

    private String bookId;

    private String memberId;

    private LocalDate loanDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private String status;
}
