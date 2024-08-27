package com.librarian.service;

import com.librarian.dto.requestDto.save.AddressSaveRequestDto;
import com.librarian.dto.requestDto.update.AddressUpdateRequestDto;
import com.librarian.dto.responseDto.AddressGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Address;
import com.librarian.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public Boolean saveAddress(AddressSaveRequestDto addressSaveRequestDto) {
        Address address = modelMapper.map(addressSaveRequestDto, Address.class);
        addressRepository.save(address);
        return true;
    }

    public Boolean updateAddress(AddressUpdateRequestDto addressUpdateRequestDto) {
        Address address = addressRepository.findById(addressUpdateRequestDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));

        address.setStreet(addressUpdateRequestDto.getStreet());
        address.setCity(addressUpdateRequestDto.getCity());
        address.setCountry(addressUpdateRequestDto.getCountry());
        address.setPostalCode(addressUpdateRequestDto.getPostalCode());

        addressRepository.save(address);
        return true;
    }

    public List<AddressGetResponseDto> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressGetResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<AddressGetResponseDto> searchAddresses(String city) {
        List<Address> addresses = addressRepository.findByCityContainingIgnoreCase(city);
        return addresses.stream()
                .map(address -> modelMapper.map(address, AddressGetResponseDto.class))
                .collect(Collectors.toList());
    }

    public void deleteAddressById(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}
