package com.librarian.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MenuController {

    @GetMapping("/menu")
    public ResponseEntity<Map<String, String>> getMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("home", "/home");
        menu.put("books", "/books");
        menu.put("members", "/members");
        menu.put("reservations", "/reservations");

        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
}
