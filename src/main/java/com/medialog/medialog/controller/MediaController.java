package com.medialog.medialog.controller;

import com.medialog.medialog.media.Book;
import com.medialog.medialog.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mediaCenter")
@CrossOrigin
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping("")
    public String home(){
        return "Welcome to your book collection";
    }

    @GetMapping("getbooks")
    public List<Book> getAllBooks(){
        return mediaService.getAllBooks();
    }

    @PostMapping("addnewbook")
    public void registerBook(@RequestBody Book book){
        mediaService.addNewBook(book);
    }

    @DeleteMapping("deletebook")
    public void deleteBook(@RequestParam Long id){
        mediaService.deleteBook(id);
    }



}
