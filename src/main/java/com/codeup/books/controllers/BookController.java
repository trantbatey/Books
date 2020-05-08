package com.codeup.books.controllers;

import com.codeup.books.model.Book;
import com.codeup.books.model.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BookController {
    private final BookRepository bookDao;

    public BookController(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        model.addAttribute("message", null);
        return "books/index";
    }

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookDao.findById(id));
        return "books/show";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id).get();
        // if book if not found, send to book list with a message
        if (book == null) {
            model.addAttribute("message", "Book not found");
            return "books/index";
        }
        model.addAttribute("book", book);
        return "books/edit";
    }

    @PostMapping("/books/edit")
    public RedirectView updateBook(@RequestParam(name = "id") long id,
                                   @RequestParam(name = "title") String title,
                                   @RequestParam(name = "description") String description,
                                   Model model) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setDescription(description);
        bookDao.save(book);
        return new RedirectView("/books");
    }

    @GetMapping("/books/delete/{id}")
    public RedirectView deleteBook(@PathVariable long id, Model model) {
        bookDao.deleteById(id);
        return new RedirectView("/books");
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
        bookDao.save(book);
        return new RedirectView("/books");
    }
}
