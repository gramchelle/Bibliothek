package com.librarian.controller;

import com.librarian.dto.requestDto.save.BookSaveRequestDto;
import com.librarian.dto.requestDto.update.BookUpdateRequestDto;
import com.librarian.dto.responseDto.BookGetResponseDto;
import com.librarian.dto.responseDto.MemberGetResponseDto;
import com.librarian.model.Book;
import com.librarian.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor // default olarak tanımlanmış nesneler için arkada default olarak bir constructor oluşturuyor.
public class BookController {

    private final BookService bookService;

    @PostMapping("/saveBook")
    public ResponseEntity<Boolean> saveBook(@RequestBody BookSaveRequestDto bookSaveRequestDto){
        Boolean savedBook = bookService.saveBook(bookSaveRequestDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    private final Map<String, Integer> urlHitCounts = new HashMap<>();

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //DOESN'T WORK
    @GetMapping("/bookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return true;
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody BookUpdateRequestDto bookUpdateRequestDto) {
        Book updatedBook = bookService.updateBook(bookUpdateRequestDto);
        return ResponseEntity.ok(updatedBook);
    }

}
