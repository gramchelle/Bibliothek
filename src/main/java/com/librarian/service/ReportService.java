package com.librarian.service;

import com.librarian.model.Book;
import com.librarian.model.Loan;
import com.librarian.repository.BookRepository;
import com.librarian.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Loan> getLoanReports() {
        return loanRepository.findAll();  // Basit bir örnek, gerçek raporlamada daha fazla iş mantığı ekleyebilirsiniz
    }

    public List<Book> getPopularBooks() {
        return bookRepository.findTop10ByOrderByTimesLoanedDesc();  // Örnek olarak en çok ödünç alınan 10 kitabı getirir
    }
}
