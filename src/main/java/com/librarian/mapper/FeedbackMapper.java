package com.librarian.mapper;

import com.librarian.dto.responseDto.FeedbackGetResponseDto;
import com.librarian.model.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackGetResponseDto toDto(Feedback feedback) {
        FeedbackGetResponseDto dto = new FeedbackGetResponseDto();
        dto.setId(feedback.getId());
        dto.setBookId(feedback.getBook().getId());
        dto.setMemberId(feedback.getMember().getId());
        dto.setComment(feedback.getComment());
        dto.setRating(feedback.getRating());
        return dto;
    }

    public Feedback toEntity(FeedbackGetResponseDto dto) {
        Feedback feedback = new Feedback();
        feedback.setId(dto.getId());
        feedback.setComment(dto.getComment());
        feedback.setRating(dto.getRating());
        return feedback;
    }
}
