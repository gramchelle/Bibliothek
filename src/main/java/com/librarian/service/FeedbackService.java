package com.librarian.service;

import com.librarian.dto.responseDto.FeedbackGetResponseDto;
import com.librarian.mapper.FeedbackMapper;
import com.librarian.model.Book;
import com.librarian.model.Feedback;
import com.librarian.model.Member;
import com.librarian.repository.FeedbackRepository;
import com.librarian.repository.BookRepository;
import com.librarian.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final FeedbackMapper feedbackMapper;

    public FeedbackGetResponseDto saveFeedback(Long bookId, Long memberId,
                                               FeedbackGetResponseDto feedbackDto) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Feedback feedback = feedbackMapper.toEntity(feedbackDto);
        feedback.setBook(book);
        feedback.setMember(member);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return feedbackMapper.toDto(savedFeedback);
    }

    public List<FeedbackGetResponseDto> getFeedbacksByBook(Long bookId) {
        return feedbackRepository.findAll().stream()
                .filter(fb -> fb.getBook().getId().equals(bookId))
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<FeedbackGetResponseDto> getFeedbacksByMember(Long memberId) {
        return feedbackRepository.findAll().stream()
                .filter(fb -> fb.getMember().getId().equals(memberId))
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }
}

