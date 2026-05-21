package com.viinidev.library.controller;

import com.viinidev.library.dto.BookRequest;
import com.viinidev.library.dto.BookResponse;
import com.viinidev.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody @Valid BookRequest request) {
        return bookService.create(request);
    }

    @GetMapping
    public List<BookResponse> list() {
        return bookService.list();
    }
}
