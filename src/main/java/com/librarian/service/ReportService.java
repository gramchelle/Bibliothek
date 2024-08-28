package com.librarian.service;

import com.librarian.model.*;
import com.librarian.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReservationRepository reservationRepository;
    private final BookRepository bookRepository;

    public List<Reservation> getLoanReports() {
        return reservationRepository.findAll();  // Basit bir örnek, gerçek raporlamada daha fazla iş mantığı ekleyebilirsiniz
    }

    public List<Book> getPopularBooks() {
        return bookRepository.findTop10ByOrderByTimesLoanedDesc();
    }
}
