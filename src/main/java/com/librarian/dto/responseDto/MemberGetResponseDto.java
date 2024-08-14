package com.librarian.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberGetResponseDto {
    // getting member information layer

    private Long id;
    private String name;
    private String surname;
    private String email;

}
