package com.librarian.controller;

import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.save.MemberSaveRequestDto;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.responseDto.LoanGetResponseDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.model.Address;
import com.librarian.model.Loan;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<Map<String, String>> getMenu() {
        Map<String, String> member = new LinkedHashMap<>();
        member.put("All Members", "/member/getAll");
        member.put("Get Members By Id", "/member/getById/");
        member.put("Member Loans By Id", "/member/{id}/loans");
        member.put("Member Reservations By Id", "/member/{id}/reservations");

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/saveMember")
    public ResponseEntity<Boolean> saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        if (memberSaveRequestDto.getName() == null || memberSaveRequestDto.getEmail() == null) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<MemberGetResponseDto> getMemberById(@PathVariable Long memberId) {
        MemberGetResponseDto memberDto = memberService.getMemberById(memberId);
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

    @PutMapping("/update/{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto dto) {
        Member updatedMember = memberService.updateMember(memberId, dto);
        return ResponseEntity.ok(updatedMember);
    }

    @PostMapping("/{memberId}/addAddress")
    public ResponseEntity<MemberGetResponseDto> addAddressToMember(@PathVariable Long memberId, @RequestBody Address address) {
        Member member = memberService.addAddressToMember(memberId, address);
        MemberGetResponseDto responseDto = modelMapper.map(member, MemberGetResponseDto.class);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{memberId}/addReservation")
    public ResponseEntity<Void> addReservation(@PathVariable Long memberId, @RequestBody ReservationSaveRequestDto reservationSaveRequestDto) {
        memberService.addReservation(memberId, reservationSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{memberId}/addLoan")
    public ResponseEntity<Void> addLoan(@PathVariable Long memberId, @RequestBody LoanSaveRequestDto loanSaveRequestDto) {
        memberService.addLoan(memberId, loanSaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

// get address

    @GetMapping("/{memberId}/reservations")
    public ResponseEntity<List<ReservationGetResponseDto>> getReservationsByMember(@PathVariable Long memberId) {
        List<ReservationGetResponseDto> reservations = memberService.getReservationsByMember(memberId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{memberId}/loans")
    public ResponseEntity<List<LoanGetResponseDto>> getLoansByMember(@PathVariable Long memberId) {
        List<LoanGetResponseDto> loans = memberService.getLoansByMember(memberId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}
