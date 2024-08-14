package com.librarian.dto.requestDto.save;
import com.fasterxml.jackson.annotation.JsonFormat;


import com.librarian.model.Book;
import com.librarian.model.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoanSaveRequestDto {

    private Book book;

    private Member member;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate loanDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    private String status;
}
