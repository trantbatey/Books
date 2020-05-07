package com.codeup.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @GetMapping("/books")
    @ResponseBody
    public String showBooks() {
        return "Books index page";
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public String showBook(@PathVariable int id) {
        return "View information for an individual book " + id + ".";
    }

    @GetMapping("/books/create")
    @ResponseBody
    public String gotoBookCreationForm() {
        return "View the form for creating a book entry.";
    }

    @PostMapping("/books/create")
    @ResponseBody
    public String createBook() {
        return "Create a new book entry";
    }
}
