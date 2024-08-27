package com.librarian.service;

import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
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

    public Reservation updateReservation(Long id, ReservationUpdateRequestDto reservationUpdateRequestDto) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));

        reservation.setReservationDate(reservationUpdateRequestDto.getReservationDate());
        reservation.setStatus(reservationUpdateRequestDto.getStatus());

        return reservationRepository.save(reservation);
    }

//    public ReservationGetResponseDto getReservationById(Long reservationId) {
//        Reservation reservation = reservationRepository.findById(reservationId)
//                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));
//
//        return new ReservationGetResponseDto(
//                reservation.getId(),
//                reservation.getReservationDate(),
//                reservation.getStatus()
//        );
//    }


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

