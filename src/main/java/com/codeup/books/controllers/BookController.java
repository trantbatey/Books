package com.codeup.books.controllers;

import com.codeup.books.model.Book;
import com.codeup.books.model.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BookController {
    private final BookRepository bookDao;

    public BookController(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "books/index";
    }

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookDao.findById(id));
        return "books/show";
    }

    @PostMapping("/books/edit/{title}")
    public String gotoEditBook(@PathVariable String title, Model model) {
        model.addAttribute("book", bookDao.findByTitle(title));
        return "books/edit";
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
