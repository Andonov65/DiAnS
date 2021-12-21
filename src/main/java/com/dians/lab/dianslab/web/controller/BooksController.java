package com.dians.lab.dianslab.web.controller;


import com.dians.lab.dianslab.model.Book;
import com.dians.lab.dianslab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getSelectedBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "SelectedBook";
    }


    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error,
                                   @RequestParam(required = false) String searchText, Model model){

        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Book> books = this.bookService.findAllBooks();
        /*if(type != null){
            books = this.bookService.findAllBooks().stream()
                    .filter(i->i.getType().equals(type)).collect(Collectors.toList()); } */


        if(searchText!=null) {
            books = this.bookService.fullTextSearch(searchText);
        }
            model.addAttribute("books", books);


        return "Books";
    }


}
