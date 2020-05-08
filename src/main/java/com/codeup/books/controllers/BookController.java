package com.codeup.books.controllers;

import com.codeup.books.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public String gotoBookCreationForm() {
        return "/books/create";
    }

    @PostMapping("/books/create")
    public RedirectView createBook(@RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description,
                             Model model) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        System.out.println(book.getTitle());
        System.out.println(book.getDescription());
        return new RedirectView("/books");
    }
}
