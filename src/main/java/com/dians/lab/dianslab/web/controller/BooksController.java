package com.dians.lab.dianslab.web.controller;


import com.dians.lab.dianslab.model.Book;
import com.dians.lab.dianslab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBooksPage(Model model){
        List<Book> books = this.bookService.findAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("mostReadBooks",this.bookService.sortByMostRead());
        return "Books";
    }

    @GetMapping("/{id}")
    public String getSelectedBook(@PathVariable Long id, Model model){
        Optional<Book> book = bookService.findBookById(id);
        model.addAttribute("book", book);
        List<Book> similarBooks = this.bookService.findSimilar(book.get().getAuthorName());
       model.addAttribute("similarBooks",similarBooks);
        return "SelectedBook";
    }
}
