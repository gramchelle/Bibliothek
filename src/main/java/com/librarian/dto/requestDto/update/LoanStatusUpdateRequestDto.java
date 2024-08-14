package com.librarian.dto.requestDto.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanStatusUpdateRequestDto {

    private Long loanId;

    private String status; // Borrowed/Active, Returned, Late
}
