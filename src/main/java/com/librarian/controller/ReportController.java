package com.librarian.controller;

import com.librarian.model.*;
import com.librarian.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/loans")
    public List<Reservation> getLoanReports() {
        return reportService.getLoanReports();
    }

    @GetMapping("/popular-books")
    public List<Book> getPopularBooks() {
        return reportService.getPopularBooks();
    }
}

