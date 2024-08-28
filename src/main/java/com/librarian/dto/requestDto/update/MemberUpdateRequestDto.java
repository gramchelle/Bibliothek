package com.librarian.dto.requestDto.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateRequestDto {

    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private int birth_year;
}
