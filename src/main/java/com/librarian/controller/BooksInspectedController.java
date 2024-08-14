package com.librarian.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BooksInspectedController {
   /*
   @GetMapping("/{title}")
    public String getBook(@PathVariable String title) {
        String url = "/book/" + title;
        urlHitCounts.put(url, urlHitCounts.getOrDefault(url, 0) + 1);

        return "Book: " + title + " - Hit Count: " + urlHitCounts.get(url);
    }

    @GetMapping("/{title}/hits")
    public int getBookHitCount(@PathVariable String title) {
        String url = "/book/" + title;
        return urlHitCounts.getOrDefault(url, 0);
    }

    */
}
