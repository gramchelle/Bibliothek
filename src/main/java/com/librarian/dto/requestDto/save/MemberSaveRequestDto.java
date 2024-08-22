package com.librarian.dto.requestDto.save;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberSaveRequestDto {

    private String name;
    private String surname;
    private String email;
    private String addresses;
}
