package com.librarian.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 36, nullable = false, unique = true)
    private UUID isbn;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String category;

    @Column(nullable = false)
    private int publicationYear;

}
