package com.librarian.service;

import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public Boolean saveReservation(ReservationSaveRequestDto reservationSaveRequestDto) {
        Reservation reservation = modelMapper.map(reservationSaveRequestDto, Reservation.class);
        reservationRepository.save(reservation);
        return true;
    }

    public Reservation updateReservation(Long id, ReservationUpdateRequestDto dto) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setReservationDate(dto.getReservationDate());
        reservation.setReturnDate(dto.getReturnDate());
        reservation.setStatus(dto.getStatus());

        return reservationRepository.save(reservation);
    }

    public ReservationGetResponseDto getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with ID: " + id));

        // Debug or log to ensure title is being set
        System.out.println("Reservation title: " + reservation.getBook().getTitle());

        ReservationGetResponseDto responseDto = modelMapper.map(reservation, ReservationGetResponseDto.class);
        return responseDto;
    }

    public List<ReservationGetResponseDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationGetResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<Reservation> searchReservations(String status) {
        return reservationRepository.findByStatusContainingIgnoreCase(status);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
        reservationRepository.delete(reservation);
    }

}

