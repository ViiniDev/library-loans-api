package com.viinidev.library.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LoanRequest(
        @NotNull Long bookId,
        @NotNull Long readerId,
        @NotNull @Future LocalDate dueDate
) {
}
