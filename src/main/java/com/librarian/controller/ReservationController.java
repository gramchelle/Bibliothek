package com.librarian.controller;

import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
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

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveReservation(@RequestBody ReservationSaveRequestDto reservationSaveRequestDto) {
        Boolean saveReservation = reservationService.saveReservation(reservationSaveRequestDto);
        return new ResponseEntity<>(saveReservation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateReservation(@RequestBody ReservationUpdateRequestDto reservationUpdateRequestDto) {
        Boolean updateResult = reservationService.updateReservation(reservationUpdateRequestDto);
        return new ResponseEntity<>(updateResult, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationGetResponseDto>> getAllReservations() {
        List<ReservationGetResponseDto> reservationGetResponseDtos = reservationService.getAllReservations();
        return new ResponseEntity<>(reservationGetResponseDtos, HttpStatus.OK);
    }

}
