package com.librarian.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("")
    public ResponseEntity<Map<String, String>> getMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("home", "/home");
        menu.put("books", "/book/getAll");
        menu.put("members", "/member/getAll");
        menu.put("reservations", "/reservations");
        menu.put("staff", "/staff");
        menu.put("search", "/search?keyword=");

        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
}
