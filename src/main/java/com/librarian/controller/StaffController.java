package com.librarian.controller;

import com.librarian.dto.requestDto.save.StaffSaveRequestDto;
import com.librarian.dto.requestDto.update.StaffUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.StaffGetResponseDto;
import com.librarian.model.Staff;
import com.librarian.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveStaff(@RequestBody StaffSaveRequestDto staffSaveRequestDto){
        Boolean saveStaff = staffService.saveStaff(staffSaveRequestDto);
        return new ResponseEntity<>(saveStaff, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StaffGetResponseDto>> getAllMembers() {
        List<StaffGetResponseDto> staffGetResponseDtos = staffService.getAllMembers();
        return ResponseEntity.ok(staffGetResponseDtos);
    }

    @GetMapping("/byId/{staffId}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long staffId) {
        Staff staff = staffService.getStaffById(staffId);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<String> deleteStaffById(@PathVariable Long staffId) {
        boolean isDeleted = staffService.deleteStaffById(staffId);
        if (isDeleted) {
            return ResponseEntity.ok("Staff deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found with the id" + staffId);
        }
    }

    @PutMapping("/update/{staffId}")
    public ResponseEntity<String> updateStaff(@RequestBody StaffUpdateRequestDto staffUpdateRequestDto,
                                              @PathVariable Long staffId) {
        boolean isUpdated = staffService.updateStaff(staffUpdateRequestDto, staffId);
        if (isUpdated) {
            return ResponseEntity.ok("Staff updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found with the id" + staffId);
        }
    }


}
