package com.librarian.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
