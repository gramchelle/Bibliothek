package com.librarian.controller;

import com.librarian.dto.responseDto.FeedbackGetResponseDto;
import com.librarian.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping("/add/{bookId}/{memberId}")
    public FeedbackGetResponseDto addFeedback(@PathVariable Long bookId, @PathVariable Long memberId, @RequestBody FeedbackGetResponseDto feedbackDto) {
        return feedbackService.saveFeedback(bookId, memberId, feedbackDto);
    }

    @GetMapping("/book/{bookId}")
    public List<FeedbackGetResponseDto> getFeedbacksByBook(@PathVariable Long bookId) {
        return feedbackService.getFeedbacksByBook(bookId);
    }

    @GetMapping("/member/{memberId}")
    public List<FeedbackGetResponseDto> getFeedbacksByMember(@PathVariable Long memberId) {
        return feedbackService.getFeedbacksByMember(memberId);
    }
}
