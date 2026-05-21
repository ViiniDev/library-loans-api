package com.viinidev.library.dto;

import com.viinidev.library.domain.Loan;
import com.viinidev.library.domain.LoanStatus;

import java.time.LocalDate;

public record LoanResponse(
        Long id,
        BookResponse book,
        ReaderResponse reader,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        LoanStatus status,
        boolean overdue
) {

    public static LoanResponse from(Loan loan) {
        return new LoanResponse(
                loan.getId(),
                BookResponse.from(loan.getBook()),
                ReaderResponse.from(loan.getReader()),
                loan.getLoanDate(),
                loan.getDueDate(),
                loan.getReturnDate(),
                loan.getStatus(),
                loan.isOverdue()
        );
    }
}
