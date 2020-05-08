package com.codeup.books.controllers;

import com.codeup.books.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setTitle("Twilight");
        book.setDescription("The biting story of how a high school transfer coed falls in love with a vampire.");
        bookList.add(book);
        book = new Book();
        book.setTitle("The Host");
        book.setDescription("An alien and a human fight each other for control of their body.");
        bookList.add(book);

        model.addAttribute("books", bookList);
        return "books/index";
    }

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable int id, Model model) {
        Book book = new Book();
        book.setTitle("Twilight");
        book.setDescription("The biting story of how a high school transfer coed falls in love with a vampire.");
        model.addAttribute("book", book);
        return "books/show";
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
