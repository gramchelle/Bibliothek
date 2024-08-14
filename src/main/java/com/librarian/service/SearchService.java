package com.librarian.service;

import com.librarian.dto.responseDto.SearchResultDto;
import com.librarian.model.Book;
import com.librarian.model.Member;
import com.librarian.model.Reservation;
import com.librarian.repository.BookRepository;
import com.librarian.repository.MemberRepository;
import com.librarian.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.util.List;

@Service
@AllArgsConstructor
public class SearchService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;

    public SearchResultDto search(String keyword) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(keyword);
        List<Member> members = memberRepository.findByNameContainingIgnoreCase(keyword);
        List<Reservation> reservations = reservationRepository.findByStatusContainingIgnoreCase(keyword);

        return new SearchResultDto(books, members, reservations);
    }
}
