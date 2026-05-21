package com.viinidev.library.dto;

import com.viinidev.library.domain.Book;
import com.viinidev.library.domain.BookStatus;

public record BookResponse(Long id, String title, String author, String isbn, BookStatus status) {

    public static BookResponse from(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getStatus());
    }
}
