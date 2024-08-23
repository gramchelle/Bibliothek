package com.librarian.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private UUID postalCode;

    @Column
    private String street;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
