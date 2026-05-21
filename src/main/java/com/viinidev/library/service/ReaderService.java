package com.viinidev.library.service;

import com.viinidev.library.domain.Reader;
import com.viinidev.library.dto.ReaderRequest;
import com.viinidev.library.dto.ReaderResponse;
import com.viinidev.library.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public ReaderResponse create(ReaderRequest request) {
        if (readerRepository.existsByEmailIgnoreCase(request.email())) {
            throw new IllegalArgumentException("Email already registered.");
        }
        return ReaderResponse.from(readerRepository.save(new Reader(request.name(), request.email())));
    }

    public List<ReaderResponse> list() {
        return readerRepository.findAll().stream().map(ReaderResponse::from).toList();
    }

    public Reader getById(Long id) {
        return readerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reader not found."));
    }
}
