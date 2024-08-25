package com.librarian.service;

import com.librarian.dto.requestDto.save.StaffSaveRequestDto;
import com.librarian.dto.requestDto.update.StaffUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.StaffGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Staff;
import com.librarian.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public Boolean saveStaff(StaffSaveRequestDto staffSaveRequestDto) {
        Staff staff = modelMapper.map(staffSaveRequestDto, Staff.class);
        staffRepository.save(staff);
        return true;
    }

    public List<StaffGetResponseDto> getAllMembers() {
        List<Staff> staffs = (List<Staff>) staffRepository.findAll();
        return staffs.stream().map(staff -> {
            StaffGetResponseDto responseDto = new StaffGetResponseDto();
            responseDto.setId(staff.getId());
            responseDto.setName(staff.getName());
            responseDto.setLastName(staff.getLastName());
            responseDto.setPosition(staff.getPosition());
            return responseDto;
        }).collect(Collectors.toList());
    }

    public boolean deleteStaffById(Long id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateStaff(StaffUpdateRequestDto staffUpdateRequestDto, Long staffId) {
        Optional<Staff> existingStaff = staffRepository.findById(staffId);
        if (existingStaff.isPresent()) {
            Staff staff = existingStaff.get();
            staff.setName(staffUpdateRequestDto.getName());
            staff.setLastName(staffUpdateRequestDto.getLastName());
            staff.setPosition(staffUpdateRequestDto.getPosition());
            staff.setContactInfo(staffUpdateRequestDto.getContactInfo());
            staffRepository.save(staff);
            return true;
        } else {
            return false;
        }
    }

    public Staff getStaffById(Long staffId) {
        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with ID: " + staffId));
        return modelMapper.map(staff, Staff.class);

    }
}
