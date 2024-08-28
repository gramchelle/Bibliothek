package com.librarian.service;

import com.librarian.model.Book;
import com.librarian.model.Reservation;
import com.librarian.repository.BookRepository;
import com.librarian.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;

    public List<Reservation> getLoanReports() {
        return reservationRepository.findAll();
    }

    public List<Book> getPopularBooks() {
        List<Reservation> reservations = reservationRepository.findAll();

        Map<Long, Long> bookLoanCounts = reservations.stream()
                .collect(Collectors.groupingBy(reservation -> reservation.getBook().getId(), Collectors.counting()));

        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            Long loanCount = bookLoanCounts.getOrDefault(book.getId(), 0L);
            book.setTimesLoaned(loanCount.intValue());
        }

        return books.stream()
                .sorted((b1, b2) -> Integer.compare(b2.getTimesLoaned(), b1.getTimesLoaned()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
