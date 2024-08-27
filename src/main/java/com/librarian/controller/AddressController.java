package com.librarian.controller;

import com.librarian.dto.requestDto.save.AddressSaveRequestDto;
import com.librarian.dto.requestDto.update.AddressUpdateRequestDto;
import com.librarian.dto.responseDto.AddressGetResponseDto;
import com.librarian.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<Boolean> saveAddress(@RequestBody AddressSaveRequestDto addressSaveRequestDto) {
        Boolean saveAddress = addressService.saveAddress(addressSaveRequestDto);
        return new ResponseEntity<>(saveAddress, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateAddress(@RequestBody AddressUpdateRequestDto addressUpdateRequestDto) {
        Boolean updateResult = addressService.updateAddress(addressUpdateRequestDto);
        return new ResponseEntity<>(updateResult, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressGetResponseDto>> getAllAddresses() {
        List<AddressGetResponseDto> addressGetResponseDtos = addressService.getAllAddresses();
        return new ResponseEntity<>(addressGetResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AddressGetResponseDto>> searchAddresses(@RequestParam String city) {
        List<AddressGetResponseDto> addresses = addressService.searchAddresses(city);
        return ResponseEntity.ok(addresses);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
