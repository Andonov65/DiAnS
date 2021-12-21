package com.dians.lab.dianslab.repository.jpa;

import com.dians.lab.dianslab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorName(String authorName);

    List<Book> findByAuthorNameContainingIgnoreCaseOrNameContainingIgnoreCase(String search, String search2);
}
