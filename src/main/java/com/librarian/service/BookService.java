package com.librarian.service;

import com.librarian.dto.requestDto.save.BookSaveRequestDto;
import com.librarian.dto.requestDto.update.BookUpdateRequestDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Book;
import com.librarian.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Qualifier("modelMapper")
    private final ModelMapper modelMapper;

    public boolean saveBook(BookSaveRequestDto bookSaveRequestDto) {
        Book book = modelMapper.map(bookSaveRequestDto, Book.class);
        bookRepository.save(book);
        return true;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
    }

    public Boolean deleteBookById(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBook(Long bookId, BookUpdateRequestDto bookUpdateRequestDto) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(bookUpdateRequestDto.getTitle());
            existingBook.setAuthor(bookUpdateRequestDto.getAuthor());
            existingBook.setCategory(bookUpdateRequestDto.getCategory());

            return bookRepository.save(existingBook);
        } else {
            return null;
        }
    }

    public void incrementBookLoanCount(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));
        book.setTimesLoaned(book.getTimesLoaned() + 1);
        bookRepository.save(book);
    }
}