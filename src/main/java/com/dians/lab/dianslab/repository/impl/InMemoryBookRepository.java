package com.dians.lab.dianslab.repository.impl;

import com.dians.lab.dianslab.bootstrap.DataHolder;
import com.dians.lab.dianslab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository {

    public List<Book> findAll(){
        return DataHolder.bookList;
    }

    public Optional<Book> findBookById(Long id){
        return DataHolder.bookList.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}
