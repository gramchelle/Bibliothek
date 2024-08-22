package com.librarian.controller;

import com.librarian.dto.requestDto.save.MemberSaveRequestDto;
import com.librarian.dto.requestDto.delete.MemberDeleteRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.model.Member;
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
    public ResponseEntity<String> saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto) {
        Boolean success = memberService.sendEmail(memberSaveRequestDto);
        if (success) {
            return ResponseEntity.ok("Kayıt işlemi başarıyla tamamlandı ve e-posta gönderildi.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kayıt işlemi başarısız.");
        }
    }
    /*
    @PostMapping("/saveMember")
    public ResponseEntity<Boolean> saveBook(@RequestBody MemberSaveRequestDto memberSaveRequestDto){
        Boolean saveMember = memberService.saveMember(memberSaveRequestDto);
        return new ResponseEntity<>(saveMember, HttpStatus.CREATED);
    }
    */
    /*
        @DeleteMapping("/deleteMember")
        public ResponseEntity<String> deleteMember(@RequestBody MemberDeleteRequestDto deleteRequestDto) {
            String responseMessage = memberService.deleteMember(deleteRequestDto);

            if (responseMessage.equals("Deletion successful.")) {
                return new ResponseEntity<>(responseMessage, HttpStatus.OK);
            } else if (responseMessage.equals("Member not found.") || responseMessage.equals("Name and ID do not match.")) {
                return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

     */
/*
    @GetMapping("/information")
    public ResponseEntity<MemberGetResponseDto> getMemberInformation(@RequestParam("id") Long id) {
        MemberGetResponseDto requestDto = new MemberGetResponseDto();
        requestDto.setId(id);
        MemberGetResponseDto responseDto = memberService.getMemberInformation(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
*/
    @GetMapping("/getAll")
    public ResponseEntity<List<MemberGetResponseDto>> getAllMembers() {
        List<MemberGetResponseDto> responseDtoList = memberService.getAllMembers();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
        return true;
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        Member updatedMember = memberService.updateMember(memberUpdateRequestDto);
        return ResponseEntity.ok(updatedMember);
    }



}
