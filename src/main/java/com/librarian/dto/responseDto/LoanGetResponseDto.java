package com.librarian.dto.responseDto;

import com.librarian.dto.requestDto.save.BookSaveRequestDto;
import com.librarian.service.BookService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class LoanGetResponseDto {
    private Long id;
    private LocalDateTime loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private BookSaveRequestDto book;
}
