package com.librarian.service;

import com.librarian.dto.requestDto.save.BookSaveRequestDto;
import com.librarian.dto.requestDto.update.BookUpdateRequestDto;
import com.librarian.dto.responseDto.BookGetResponseDto;
import com.librarian.exception.ResourceNotFoundException;
import com.librarian.model.Book;
import com.librarian.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Book updateBook(BookUpdateRequestDto dto) {
        Book book = bookRepository.findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setCategory(dto.getCategory());
        return bookRepository.save(book);
    }


}
