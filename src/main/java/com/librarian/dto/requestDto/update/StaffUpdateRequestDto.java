package com.librarian.dto.requestDto.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffUpdateRequestDto {

    private Long id;
    private String name;
    private String lastName;
    private String position;
    private String contactInfo;
}
