package com.librarian.controller;

import com.librarian.model.Book;
import com.librarian.model.Loan;
import com.librarian.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/loans")
    public List<Loan> getLoanReports() {
        return reportService.getLoanReports();
    }

    @GetMapping("/popular-books")
    public List<Book> getPopularBooks() {
        return reportService.getPopularBooks();
    }
}
