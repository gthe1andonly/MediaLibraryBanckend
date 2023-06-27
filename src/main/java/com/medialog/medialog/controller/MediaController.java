package com.medialog.medialog.controller;

import com.medialog.medialog.User.User;
import com.medialog.medialog.User.UserDto;
import com.medialog.medialog.media.Book;
import com.medialog.medialog.service.MediaService;
import com.medialog.medialog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class MediaController {

//    (path = "api/v1/mediaCenter")
    private final MediaService mediaService;
    private final UserService userService;

    @Autowired
    public MediaController(MediaService mediaService, UserService userService) {

        this.mediaService = mediaService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String bookHome(){
        return "Welcome to your book collection";
    }

    @GetMapping("index")
    public String home(){return "index";}

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("register")
    public String showRegistration(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result, Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "An account already exists with the email.");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
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

    @PutMapping("updatebook")
    public void updateBook(@RequestParam Long id, @RequestParam String name,
                           @RequestParam String author, @RequestParam LocalDate date){
        mediaService.updateBook(id, name, author, date);
    }

    @GetMapping("/users")
    public String getUsers (Model model){
        List<UserDto> users =  userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }



}
