package com.librarian.service;
/*
import com.librarian.controller.LoanController;
import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.update.LoanStatusUpdateRequestDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Book;
import com.librarian.model.Loan;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.repository.BookRepository;
import com.librarian.repository.LoanRepository;
import com.librarian.repository.MemberRepository;
import com.librarian.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public Boolean saveLoan(LoanSaveRequestDto loanSaveRequestDto) {
        Long bookId = loanSaveRequestDto.getBook().getId();
        Long memberId = loanSaveRequestDto.getMember().getId();
        String status = loanSaveRequestDto.getStatus();

        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        Loan loan = Loan.builder()
                .status(status)
                .book(book)
                .member(member)
                .loanDate(LocalDateTime.now())
                .dueDate(LocalDate.now().plusDays(14))
                .build();

        loanRepository.save(loan);
        return true;
    }

    public List<LoanSaveRequestDto> getAllLoans() {
        List<Loan> loans = (List<Loan>) loanRepository.findAll();
        return loans.stream()
                .map(loan -> modelMapper.map(loan, LoanSaveRequestDto.class))
                .collect(Collectors.toList());
    }

    public List<LoanSaveRequestDto> getLoansByMemberId(Long memberId) {
        List<Loan> loans = loanRepository.findByMemberId(memberId);
        return loans.stream()
                .map(loan -> modelMapper.map(loan, LoanSaveRequestDto.class))
                .collect(Collectors.toList());
    }

    public void updateLoanStatus(LoanStatusUpdateRequestDto dto) {
        Loan loan = loanRepository.findById(dto.getLoanId())
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        loan.setStatus(dto.getStatus());
        loanRepository.save(loan);
    }


}
*/