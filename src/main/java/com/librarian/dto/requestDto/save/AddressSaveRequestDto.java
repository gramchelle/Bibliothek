package com.librarian.dto.requestDto.save;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressSaveRequestDto {
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
