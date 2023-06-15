package com.medialog.medialog.media;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Show extends Media{

//    @Id
//    @SequenceGenerator(name = "show_sequence", sequenceName = "show_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_sequence")
    private Long id;

    private String director;

    public Show() {
    }

    public Show(String name, String genre, LocalDate publicationDate) {
        super(name, genre, publicationDate);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
