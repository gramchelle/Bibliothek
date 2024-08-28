package com.librarian.service;
/*
import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.update.LoanUpdateRequestDto;
import com.librarian.dto.responseDto.LoanGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Loan;
import com.librarian.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public Boolean saveLoan(LoanSaveRequestDto loanSaveRequestDto) {
        Loan loan = modelMapper.map(loanSaveRequestDto, Loan.class);
        loanRepository.save(loan);
        return true;
    }

    public Boolean updateLoan(LoanUpdateRequestDto loanUpdateRequestDto) {
        Loan loan = loanRepository.findById(loanUpdateRequestDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setReturnDate(loanUpdateRequestDto.getReturnDate());
        loan.setStatus(determineStatus(loanUpdateRequestDto.getLoanDate(), loanUpdateRequestDto.getReturnDate(), loanUpdateRequestDto.getIsReturned()));
        loanRepository.save(loan);

        return true;
    }

    private String determineStatus(LocalDate loanDate, LocalDate returnDate, Boolean isReturned) {
        LocalDate currentDate = LocalDate.now();

        if (isReturned != null && isReturned) {
            return "RETURNED";
        }

        if (returnDate != null && returnDate.isBefore(currentDate)) {
            return "LATE";
        }

        if (loanDate != null) {
            return "ACTIVE";
        }

        return "BORROWED";
    }


    public List<LoanGetResponseDto> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream()
                .map(reservation -> modelMapper.map(reservation, LoanGetResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<Loan> searchLoans(String status) {
        return loanRepository.findByStatusContainingIgnoreCase(status);
    }
}
*/