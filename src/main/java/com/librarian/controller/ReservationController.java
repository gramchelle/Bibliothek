package com.librarian.controller;

import com.librarian.dto.requestDto.save.MemberSaveRequestDto;
import com.librarian.dto.requestDto.save.ReservationSaveRequestDto;
import com.librarian.dto.requestDto.update.MemberUpdateRequestDto;
import com.librarian.dto.requestDto.update.ReservationUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.ReservationGetResponseDto;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveReservation(@RequestBody ReservationSaveRequestDto reservationSaveRequestDto) {
        Boolean saveReservation = reservationService.saveReservation(reservationSaveRequestDto);
        return new ResponseEntity<>(saveReservation, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody ReservationUpdateRequestDto dto) {
        Reservation isReservationSaved = reservationService.updateReservation(id, dto);
        return ResponseEntity.ok(isReservationSaved);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationGetResponseDto>> getAllReservations() {
        List<ReservationGetResponseDto> reservationGetResponseDtos = reservationService.getAllReservations();
        return new ResponseEntity<>(reservationGetResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Reservation>> searchReservations(@RequestParam String status) {
        List<Reservation> reservations = reservationService.searchReservations(status);
        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/getById/{reservationId}")
    public ResponseEntity<ReservationGetResponseDto> getReservationById(@PathVariable Long reservationId) {
        ReservationGetResponseDto responseDto = reservationService.getReservationById(reservationId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
