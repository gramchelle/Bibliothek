package com.librarian.dto.responseDto;

import com.librarian.model.Book;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchResultDto {
    private List<Book> books;
    private List<Member> members;
    private List<Reservation> reservations;
}
