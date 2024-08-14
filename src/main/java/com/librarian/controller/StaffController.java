package com.librarian.controller;

import com.librarian.dto.requestDto.save.StaffSaveRequestDto;
import com.librarian.dto.requestDto.update.StaffUpdateRequestDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.dto.responseDto.StaffGetResponseDto;
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

    @PostMapping("/saveStaff")
    public ResponseEntity<Boolean> saveBook(@RequestBody StaffSaveRequestDto staffSaveRequestDto){
        Boolean saveStaff = staffService.saveStaff(staffSaveRequestDto);
        return new ResponseEntity<>(saveStaff, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StaffGetResponseDto>> getAllMembers() {
        List<StaffGetResponseDto> staffGetResponseDtos = staffService.getAllMembers();
        return ResponseEntity.ok(staffGetResponseDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        boolean isDeleted = staffService.deleteStaffById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Staff deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStaff(@RequestBody StaffUpdateRequestDto staffUpdateRequestDto) {
        boolean isUpdated = staffService.updateStaff(staffUpdateRequestDto);
        if (isUpdated) {
            return ResponseEntity.ok("Staff updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
    }

}
