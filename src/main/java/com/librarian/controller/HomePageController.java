package com.librarian.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/home")
    public ResponseEntity<String> greet(){
        String greeting = "Welcome to the Bibliothek.com\nA Contemporary Place to Find Books Written for You!";
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
