package com.librarian.controller;

import com.librarian.dto.responseDto.SearchResultDto;
import com.librarian.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService service;

    @GetMapping
    public SearchResultDto search(@RequestParam String keyword){
        return service.search(keyword);
    }
}
