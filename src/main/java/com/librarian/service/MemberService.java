package com.librarian.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.librarian.dto.requestDto.save.MemberSaveRequestDto;
import com.librarian.dto.requestDto.delete.MemberDeleteRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Address;
import com.librarian.model.Member;
import com.librarian.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    /*

    public Boolean saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = modelMapper.map(memberSaveRequestDto, Member.class);
        memberRepository.save(member);
        return true;
    }

     */

    public Member saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        // DTO'dan Member nesnesine dönüştür
        Member member = modelMapper.map(memberSaveRequestDto, Member.class);

        // Member nesnesini veritabanına kaydet
        Member savedMember = memberRepository.save(member);

        // E-posta gönderimi
        emailService.sendSimpleMessage(
                savedMember.getEmail(),
                "Kayıt Başarıyla Tamamlandı",
                "Hoş geldiniz " + savedMember.getName() + "! Kayıt işleminiz başarıyla tamamlandı."
        );

        // Kaydedilen member'ı döndür
        return savedMember;
    }

    // Parametre olarak MemberSaveRequestDto alır ve kayıt işlemini yapar
    public Boolean sendEmail(MemberSaveRequestDto memberSaveRequestDto) {
        Member savedMember = saveMember(memberSaveRequestDto);
        return savedMember != null;
    }

    /*
        public String deleteMember(MemberDeleteRequestDto memberDeleteRequestDto) {
            Optional<Member> memberOpt = memberRepository.findById(memberDeleteRequestDto.getId());

            if (memberOpt.isEmpty()) {
                return "Member not found.";
            }

            Member member = memberOpt.get();
            if (!member.getName().equals(memberDeleteRequestDto.getName())) {
                return "Name and ID do not match.";
            }

            memberRepository.delete(member);
            return "Deletion successful.";
        }
    */
/*
    public MemberGetResponseDto getMemberInformation(MemberGetResponseDto memberGetResponseDto) {
        return memberRepository.findById(memberGetResponseDto.getId())
                .map(member -> {
                    MemberGetResponseDto responseDto = new MemberGetResponseDto();
                    responseDto.setId(member.getId());
                    responseDto.setName(member.getName());
                    responseDto.setEmail(member.getEmail());
                    // Map other fields
                    return responseDto;
                })
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }
*/
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
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + id));

        return member;
    }

    public Boolean deleteMemberById(Long id) {
        memberRepository.deleteById(id);
        return true;
    }
    // UPDATE ÇALIŞMIYOR
    public Member updateMember(MemberUpdateRequestDto dto) {
        Member member = memberRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setName(dto.getName());
        member.setSurname(dto.getSurname());
        member.setEmail(dto.getEmail());
        System.out.println("Bu metot çalışıyor");

        try {
            List<Address> addresses = objectMapper.readValue(dto.getAddress(),
                    new TypeReference<List<Address>>() {});
            member.setAddress(addresses);
        } catch (IOException e) {
            throw new RuntimeException("Invalid address format");
        }

        return memberRepository.save(member);
    }



}
