package com.medialog.medialog.media;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class Media {

    private Long id;
    private String name;
    private String genre;

    private LocalDate publicationDate;

    public Media() {
    }


    public Media(String name, String genre, LocalDate publicationDate) {
        this.name = name;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Media{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
