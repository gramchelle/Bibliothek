package com.librarian.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

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