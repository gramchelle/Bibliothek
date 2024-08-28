package com.librarian.service;

import com.librarian.dto.requestDto.save.*;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.responseDto.*;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.*;
import com.librarian.repository.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;
//    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

//    @Autowired
//    private ObjectMapper objectMapper;

    public Boolean saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = modelMapper.map(memberSaveRequestDto, Member.class);

        System.out.println("Converted Member: " + member);

        memberRepository.save(member);
        return true;
    }

//    private boolean isEmailExists(String email) {
//        return memberRepository.findByEmail(email).isPresent();
//    }

    public List<MemberGetResponseDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(member -> {
            MemberGetResponseDto responseDto = new MemberGetResponseDto();
            responseDto.setId(member.getId());
            responseDto.setName(member.getName());
            responseDto.setEmail(member.getEmail());
            return responseDto;
        }).collect(Collectors.toList());
    }

    public MemberGetResponseDto getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));
        return modelMapper.map(member, MemberGetResponseDto.class);
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
        member.setPhone_number(dto.getPhone_number());
        member.setBirth_year(dto.getBirth_year());

        return memberRepository.save(member);
    }

    @Transactional
    public Member addAddressToMember(Long memberId, Address address) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.getAddress().add(address);
        address.setMember(member);

        return memberRepository.save(member);
    }

    @Transactional
    public boolean addReservation(Long memberId, ReservationSaveRequestDto reservationSaveRequestDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        Book book = bookRepository.findById(reservationSaveRequestDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Reservation reservation = new Reservation();
        reservation.setBook(book);
        reservation.setMember(member);
        reservation.setReservationDate(reservationSaveRequestDto.getReservationDate());
        reservation.setDueDate(reservationSaveRequestDto.getDueDate());
        reservation.setReturnDate(reservationSaveRequestDto.getReturnDate());
        reservation.setStatus(reservationSaveRequestDto.getStatus());

        reservationRepository.save(reservation);
        return true;
    }


//    @Transactional
//    public void addLoan(Long memberId, LoanSaveRequestDto loanSaveRequestDto) {
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new RuntimeException("Member not found"));
//
//        Book book = bookRepository.findById(loanSaveRequestDto.getBookId())
//                .orElseThrow(() -> new RuntimeException("Book not found"));
//
//        Loan loan = modelMapper.map(loanSaveRequestDto, Loan.class);
//        loan.setMember(member);
//        loan.setBook(book);
//
//        loanRepository.save(loan);
//    }

    public List<AddressGetResponseDto> getAddressesByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));

        return member.getAddress().stream()
                .map(address -> modelMapper.map(address, AddressGetResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<ReservationGetResponseDto> getReservationsByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));

        return member.getReservations().stream()
                .map(reservation -> {
                    ReservationGetResponseDto responseDto = new ReservationGetResponseDto();
                    responseDto.setId(reservation.getId());
                    responseDto.setReservationDate(reservation.getReservationDate());
                    responseDto.setDueDate(reservation.getDueDate());
                    responseDto.setTitle(reservation.getBook() != null ? reservation.getBook().getTitle() : null);
                    return responseDto;
                })
                .collect(Collectors.toList());
    }

//    public List<LoanGetResponseDto> getLoansByMember(Long memberId) {
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + memberId));
//
//        return member.getLoans().stream()
//                .map(loan -> modelMapper.map(loan, LoanGetResponseDto.class))
//                .collect(Collectors.toList());
//    }


}
