package com.viinidev.library.service;

import com.viinidev.library.domain.Book;
import com.viinidev.library.dto.BookRequest;
import com.viinidev.library.dto.BookResponse;
import com.viinidev.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse create(BookRequest request) {
        if (bookRepository.existsByIsbn(request.isbn())) {
            throw new IllegalArgumentException("ISBN already registered.");
        }
        return BookResponse.from(bookRepository.save(new Book(request.title(), request.author(), request.isbn())));
    }

    public List<BookResponse> list() {
        return bookRepository.findAll().stream().map(BookResponse::from).toList();
    }

    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found."));
    }
}
