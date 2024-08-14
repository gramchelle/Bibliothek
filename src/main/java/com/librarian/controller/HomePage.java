package com.librarian.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePage {

    @RequestMapping("/home")
    private String greet(){
        return "Home Page";
    }

    @RequestMapping("/")
    private void isWorking(){
        System.out.println("Çalışıyor");
    }
}
