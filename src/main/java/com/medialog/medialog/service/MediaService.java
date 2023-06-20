package com.medialog.medialog.service;

import com.medialog.medialog.media.Book;
import com.medialog.medialog.media.Media;
import com.medialog.medialog.repository.BookRepository;
import com.medialog.medialog.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;
    private final BookRepository bookRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository, BookRepository bookRepository) {
        this.mediaRepository = mediaRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
