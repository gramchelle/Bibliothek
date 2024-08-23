package com.librarian.controller;

import com.librarian.dto.requestDto.save.MemberSaveRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.model.Loan;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/saveMember")
    public ResponseEntity<Boolean> saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        boolean isMemberSaved = memberService.saveMember(memberSaveRequestDto);
        return new ResponseEntity<>(isMemberSaved, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMemberById/{memberId}")
        public ResponseEntity<Boolean> deleteMember(@PathVariable Long memberId) {
            Boolean isMemberDeleted = memberService.deleteMemberById(memberId);
            return new ResponseEntity<>(isMemberDeleted, HttpStatus.OK);
        }

    @GetMapping("/getAll")
    public ResponseEntity<List<MemberGetResponseDto>> getAllMembers() {
        List<MemberGetResponseDto> responseDtoList = memberService.getAllMembers();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/getById/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PutMapping("/update/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto dto) {
        Member updatedMember = memberService.updateMember(memberId, dto);
        return ResponseEntity.ok(updatedMember);
    }

/*
    @GetMapping("/{memberId}/reservations")
    public List<Reservation> getReservationsByMember(@PathVariable Long memberId) {
        return memberService.getReservationsByMember(memberId);
    }

    @GetMapping("/{memberId}/loans")
    public List<Loan> getLoansByMember(@PathVariable Long memberId) {
        return memberService.getLoansByMember(memberId);
    }
*/
}
