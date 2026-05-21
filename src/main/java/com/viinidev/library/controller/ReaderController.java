package com.viinidev.library.controller;

import com.viinidev.library.dto.ReaderRequest;
import com.viinidev.library.dto.ReaderResponse;
import com.viinidev.library.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReaderController {

    private final ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReaderResponse create(@RequestBody @Valid ReaderRequest request) {
        return readerService.create(request);
    }

    @GetMapping
    public List<ReaderResponse> list() {
        return readerService.list();
    }
}
