package com.medialog.medialog.media;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Movie extends Media{

//    @Id
//    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private Long id;

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie() {
    }

    public Movie(String name, String genre, LocalDate publicationDate) {
        super(name, genre, publicationDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director='" + director + '\'' +
                ", name=" + super.getName() +
                ", genre=" + super.getGenre() +
                ", publication date=" + super.getPublicationDate() +
                '}';
    }
}
