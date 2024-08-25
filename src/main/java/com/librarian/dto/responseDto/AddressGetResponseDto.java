package com.librarian.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressGetResponseDto {
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
