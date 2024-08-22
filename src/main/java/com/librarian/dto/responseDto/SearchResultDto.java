package com.librarian.dto.responseDto;

import com.librarian.model.Book;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import lombok.Data;

import java.util.List;

@Data
public class SearchResultDto {
    private List<Book> books;
    private List<Member> members;
    private List<Reservation> reservations;

    public SearchResultDto(List<Book> books, List<Member> members, List<Reservation> reservations) {
        this.books = books;
        this.members = members;
        this.reservations = reservations;
    }
}
