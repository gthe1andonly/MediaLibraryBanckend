package com.medialog.medialog.media;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Book extends Media {

//    @Id
//    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    private Long id;

    private String author;

    public Book() {
    }

    public Book(String name, String author,String genre, LocalDate publicationDate) {
        super(name, genre, publicationDate);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name=" + super.getName() +
                ", author=" + author +
                ", genre=" + super.getGenre() +
                ", publication date=" + super.getPublicationDate() +
                '}';
    }
}
