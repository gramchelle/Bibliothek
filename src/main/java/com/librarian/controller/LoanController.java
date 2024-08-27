package com.librarian.controller;

import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.LoanUpdateRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.dto.responseDto.LoanGetResponseDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.model.Loan;
import com.librarian.model.Reservation;
import com.librarian.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveLoan(@RequestBody LoanSaveRequestDto loanSaveRequestDto) {
        Boolean isLoanSaved = loanService.saveLoan(loanSaveRequestDto);
        return new ResponseEntity<>(isLoanSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateLoan(@RequestBody LoanUpdateRequestDto loanUpdateRequestDto) {
        Boolean updateResult = loanService.updateLoan(loanUpdateRequestDto);
        return new ResponseEntity<>(updateResult, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LoanGetResponseDto>> getAllReservations() {
        List<LoanGetResponseDto> loanGetResponseDtos = loanService.getAllLoans();
        return new ResponseEntity<>(loanGetResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Loan>> searchLoans(@RequestParam String status) {
        List<Loan> loans = loanService.searchLoans(status);
        return ResponseEntity.ok(loans);
    }

}
