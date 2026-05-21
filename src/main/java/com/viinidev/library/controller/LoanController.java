package com.viinidev.library.controller;

import com.viinidev.library.domain.LoanStatus;
import com.viinidev.library.dto.LoanRequest;
import com.viinidev.library.dto.LoanResponse;
import com.viinidev.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanResponse create(@RequestBody @Valid LoanRequest request) {
        return loanService.create(request);
    }

    @GetMapping
    public List<LoanResponse> list(@RequestParam(required = false) LoanStatus status) {
        return loanService.list(status);
    }

    @GetMapping("/overdue")
    public List<LoanResponse> overdue() {
        return loanService.overdue();
    }

    @PatchMapping("/{id}/return")
    public LoanResponse returnBook(@PathVariable Long id) {
        return loanService.returnBook(id);
    }
}
