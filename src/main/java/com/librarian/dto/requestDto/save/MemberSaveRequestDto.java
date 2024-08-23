package com.librarian.dto.requestDto.save;


import com.librarian.dto.AddressDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberSaveRequestDto {

    private String name;
    private String surname;
    private String email;
    private List<AddressDto> addresses;
}
