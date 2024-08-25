package com.librarian.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MemberGetResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private int birth_year;
}