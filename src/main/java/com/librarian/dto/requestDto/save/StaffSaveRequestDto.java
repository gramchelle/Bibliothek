package com.librarian.dto.requestDto.save;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StaffSaveRequestDto {

    private String name;
    private String lastName;
    private String position;
    private LocalDate hireDate;
    private String contactInfo;
}
