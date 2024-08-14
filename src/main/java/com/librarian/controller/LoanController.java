package com.librarian.controller;

import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.update.LoanStatusUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/saveLoan")
    public ResponseEntity<Boolean> saveLoan(@RequestBody LoanSaveRequestDto loanSaveRequestDto){
        Boolean savedLoan = loanService.saveLoan(loanSaveRequestDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LoanSaveRequestDto>> getAllLoans() {
        List<LoanSaveRequestDto> loanSaveRequestDtos = loanService.getAllLoans();
        return new ResponseEntity<>(loanSaveRequestDtos, HttpStatus.OK);
    }

    @GetMapping("/byMember/{memberId}")
    public List<LoanSaveRequestDto> getLoansByMemberId(@PathVariable Long memberId) {
        return loanService.getLoansByMemberId(memberId);
    }

    @PatchMapping("/status/update")
    public ResponseEntity<Void> updateLoanStatus(@RequestBody LoanStatusUpdateRequestDto loanStatusUpdateRequestDto) {
        loanService.updateLoanStatus(loanStatusUpdateRequestDto);
        return ResponseEntity.noContent().build();
    }

}
