package com.librarian.dto.requestDto.update;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationUpdateRequestDto {

    private Long id;
    private Long bookId;
    private Long memberId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
}
