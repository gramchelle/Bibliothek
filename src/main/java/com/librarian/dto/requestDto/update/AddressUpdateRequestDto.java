package com.librarian.dto.requestDto.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressUpdateRequestDto {
    private Long id;
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
