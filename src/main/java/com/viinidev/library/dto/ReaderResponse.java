package com.viinidev.library.dto;

import com.viinidev.library.domain.Reader;

public record ReaderResponse(Long id, String name, String email) {

    public static ReaderResponse from(Reader reader) {
        return new ReaderResponse(reader.getId(), reader.getName(), reader.getEmail());
    }
}
