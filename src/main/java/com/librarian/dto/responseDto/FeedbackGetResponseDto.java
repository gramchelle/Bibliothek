package com.librarian.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackGetResponseDto {
    private Long id;
    private Long bookId;
    private Long memberId;
    private String comment;
    private int rating;
}
