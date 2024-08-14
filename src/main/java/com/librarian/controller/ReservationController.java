package com.librarian.controller;

import com.librarian.dto.requestDto.save.LoanSaveRequestDto;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.LoanStatusUpdateRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/saveReservation")
    public ResponseEntity<Boolean> saveReservation(@RequestBody LoanSaveRequestDto reservationSaveRequestDto){
        Boolean saveReservation = reservationService.saveReservation(reservationSaveRequestDto);
        return new ResponseEntity<>(saveReservation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public Boolean updateReservation(@RequestBody ReservationUpdateRequestDto reservationUpdateRequestDto) {
        reservationService.updateLoanStatus(reservationUpdateRequestDto);
        return true;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationSaveRequestDto>> getAllReservations() {
        List<ReservationSaveRequestDto> reservationSaveRequestDtos = reservationService.getAllReservations();
        return new ResponseEntity<>(reservationSaveRequestDtos, HttpStatus.OK);
    }

}
