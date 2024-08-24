package com.librarian.dto.requestDto.update;

import com.librarian.model.Address;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MemberUpdateRequestDto {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
}
