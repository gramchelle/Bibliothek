package com.librarian.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "member")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "phone_number")
    private String phone_number;

    @Column(nullable = false, name = "birth_year")
    private int birth_year;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonIgnore
    private List<Address> address;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private List<Feedback> feedbacks;

}



//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Loan> loans;

//    private boolean isAdmin = false;