package com.dians.lab.dianslab.service.impl;

import com.dians.lab.dianslab.model.Book;
import com.dians.lab.dianslab.repository.jpa.BookRepository;
import com.dians.lab.dianslab.service.BookService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return this.bookRepository.findById(id);
    }

    //add this
    @Override
    public Book findMostReadBook() {
        //return this.bookRepository.findMostReadBook().get(0);
        int max=-1;
        Book maxRead = new Book();
        List<Book> books = this.bookRepository.findAll();
        for(int i=0; i<books.size(); i++){
            if(books.get(i).getCounter_read() > max){
                max = books.get(i).getCounter_read();
                maxRead = books.get(i);
            }
        }
        return maxRead;
    }

    @Override
    public List<Book> sortByMostRead() {
        return this.bookRepository.findAll().stream().sorted(Comparator.comparing(Book::getCounter_read).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Book> findSimilar(String text) {
        return this.bookRepository.findAll().stream().filter(b -> b.getAuthorName().equals(text)).collect(Collectors.toList());
    }
}
