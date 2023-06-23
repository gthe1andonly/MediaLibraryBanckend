package com.medialog.medialog.service;

import com.medialog.medialog.media.Book;
import com.medialog.medialog.media.Media;
import com.medialog.medialog.repository.BookRepository;
import com.medialog.medialog.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void updateBook(@NonNull Long id, String name, String author, LocalDate date){
        Book book = bookRepository.findById(id).orElseThrow(()-> new IllegalStateException("Book id:"+id+" does not exists"));
        if(name != null && !Objects.equals(book.getName(), name)){
            book.setName(name);
        }
        if(author != null && !Objects.equals(book.getAuthor(), author)){
            book.setAuthor(author);
        }
        if(date != null && Objects.equals(book.getPublicationDate(), date)){
            book.setPublicationDate(date);
        }

        bookRepository.save(book);

    }

}
