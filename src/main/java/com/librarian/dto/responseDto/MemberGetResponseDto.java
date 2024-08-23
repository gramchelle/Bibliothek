package com.librarian.dto.responseDto;

import com.librarian.model.Address;
import com.librarian.model.Loan;
import com.librarian.model.Reservation;
import lombok.Data;

import java.util.List;

@Data
public class MemberGetResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private List<Address> addresses;
    private List<Reservation> reservations;
    private List<Loan> loans;
}