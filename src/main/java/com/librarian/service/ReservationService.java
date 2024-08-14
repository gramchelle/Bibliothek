package com.librarian.service;

import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Loan;
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

    public Boolean saveReservation(LoanSaveRequestDto reservationSaveRequestDto) {
        Reservation reservation = modelMapper.map(reservationSaveRequestDto, Reservation.class);
        reservationRepository.save(reservation);
        return true;
    }

    public void updateLoanStatus(ReservationUpdateRequestDto reservationUpdateRequestDto) {
        Reservation reservation = reservationRepository.findById(reservationUpdateRequestDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));
        reservation.setStatus(reservationUpdateRequestDto.getStatus());
        reservationRepository.save(reservation);
    }

    public List<ReservationSaveRequestDto> getAllReservations() {
        List<Reservation> reservations = (List<Reservation>) reservationRepository.findAll();
        return reservations.stream()
                .map(reservation -> modelMapper.map(reservation, ReservationSaveRequestDto.class))
                .collect(Collectors.toList());
    }
}
