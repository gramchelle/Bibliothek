package com.librarian.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.librarian.dto.requestDto.save.MemberSaveRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.responseDto.LoanGetResponseDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Address;
import com.librarian.model.Loan;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;
    private final LoanRepository loanRepository;

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    public Boolean saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = modelMapper.map(memberSaveRequestDto, Member.class);
        memberRepository.save(member);
        return true;

    }
    private boolean isEmailExists(String email) {
        return memberRepository.findByEmail(email).isPresent();
    }

    public List<MemberGetResponseDto> getAllMembers() {
        List<Member> members = (List<Member>) memberRepository.findAll();
        return members.stream().map(member -> {
            MemberGetResponseDto responseDto = new MemberGetResponseDto();
            responseDto.setId(member.getId());
            responseDto.setName(member.getName());
            responseDto.setEmail(member.getEmail());
            return responseDto;
        }).collect(Collectors.toList());
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + id));
    }

    public Boolean deleteMemberById(Long id) {
        memberRepository.deleteById(id);
        return true;
    }

    public Member updateMember(Long memberId, MemberUpdateRequestDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setName(dto.getName());
        member.setSurname(dto.getSurname());
        member.setEmail(dto.getEmail());

        if (dto.getAddress() != null && !dto.getAddress().isEmpty()) {
            member.setAddress(dto.getAddress());
        }

        return memberRepository.save(member);
    }

    public List<ReservationGetResponseDto> getReservationsByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));

        return member.getReservations().stream()
                .map(reservation -> modelMapper.map(reservation, ReservationGetResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<LoanGetResponseDto> getLoansByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));

        return member.getLoans().stream()
                .map(loan -> modelMapper.map(loan, LoanGetResponseDto.class))
                .collect(Collectors.toList());
    }


}
