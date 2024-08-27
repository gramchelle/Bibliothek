package com.librarian.repository;

import com.librarian.model.Address;
import com.librarian.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByCityContainingIgnoreCase(String city);
}
