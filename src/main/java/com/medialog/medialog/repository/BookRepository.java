package com.medialog.medialog.repository;

import com.medialog.medialog.media.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
