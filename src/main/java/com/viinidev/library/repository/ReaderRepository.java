package com.viinidev.library.repository;

import com.viinidev.library.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

    boolean existsByEmailIgnoreCase(String email);
}
