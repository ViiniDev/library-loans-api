package com.viinidev.library.service;

import com.viinidev.library.domain.*;
import com.viinidev.library.dto.LoanRequest;
import com.viinidev.library.dto.LoanResponse;
import com.viinidev.library.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final ReaderService readerService;

    public LoanService(LoanRepository loanRepository, BookService bookService, ReaderService readerService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
        this.readerService = readerService;
    }

    @Transactional
    public LoanResponse create(LoanRequest request) {
        Book book = bookService.getById(request.bookId());
        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new IllegalArgumentException("Book is not available for loan.");
        }

        Reader reader = readerService.getById(request.readerId());
        book.markAsBorrowed();
        Loan loan = new Loan(book, reader, LocalDate.now(), request.dueDate());
        return LoanResponse.from(loanRepository.save(loan));
    }

    public List<LoanResponse> list(LoanStatus status) {
        List<Loan> loans = status == null ? loanRepository.findAll() : loanRepository.findByStatus(status);
        return loans.stream().map(LoanResponse::from).toList();
    }

    public List<LoanResponse> overdue() {
        return loanRepository.findByStatusAndDueDateBefore(LoanStatus.ACTIVE, LocalDate.now())
                .stream()
                .map(LoanResponse::from)
                .toList();
    }

    @Transactional
    public LoanResponse returnBook(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found."));
        if (loan.getStatus() == LoanStatus.RETURNED) {
            throw new IllegalArgumentException("Loan already returned.");
        }
        loan.close(LocalDate.now());
        return LoanResponse.from(loanRepository.save(loan));
    }
}
