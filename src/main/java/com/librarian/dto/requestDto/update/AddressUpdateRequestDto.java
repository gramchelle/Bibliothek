package com.librarian.dto.requestDto.update;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({"member"})
public class AddressUpdateRequestDto {
    private Long id;
    private String street;
    private String city;
    private String country;
    private String postalCode;
}
