package com.librarian.dto.requestDto.save;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoanSaveRequestDto {

    private Long bookId;
    private Long memberId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate loanDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    private String status;
}
