package com.librarian.controller;
/*
import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.LoanUpdateRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.dto.responseDto.LoanGetResponseDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.model.Loan;
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
    public ResponseEntity<LoanGetResponseDto> saveLoan(@RequestBody LoanSaveRequestDto loanSaveRequestDto) {
        LoanGetResponseDto savedLoan = loanService.saveLoan(loanSaveRequestDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<LoanGetResponseDto> getLoanById(@PathVariable Long id) {
        LoanGetResponseDto loan = loanService.getLoanById(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateLoan(@PathVariable Long id, @RequestBody LoanUpdateRequestDto loanUpdateRequestDto) {
        Boolean updateResult = loanService.updateLoan(id, loanUpdateRequestDto);
        return new ResponseEntity<>(updateResult, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LoanGetResponseDto>> getAllLoans() {
        List<LoanGetResponseDto> loanGetResponseDtos = loanService.getAllLoans();
        return new ResponseEntity<>(loanGetResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Loan>> searchLoans(@RequestParam String status) {
        List<Loan> loans = loanService.searchLoans(status);
        return ResponseEntity.ok(loans);
    }

}
*/