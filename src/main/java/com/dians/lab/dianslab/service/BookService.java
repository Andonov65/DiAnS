package com.dians.lab.dianslab.service;

import com.dians.lab.dianslab.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> findAllBooks();
    Optional<Book> findBookById(Long id);
    //add this
    Book findMostReadBook();
    List<Book> sortByMostRead();
    List<Book> findSimilar(String text);
}
