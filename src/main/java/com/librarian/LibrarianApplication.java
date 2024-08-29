package com.librarian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LibrarianApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to the Bibliothek.com\n" +
                "A Contemporary Place to Find Books Written for You!");
        SpringApplication.run(LibrarianApplication.class, args);
    }

}
