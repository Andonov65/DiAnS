package com.dians.lab.dianslab.repository.jpa;

import com.dians.lab.dianslab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //add this
    //@Query("SELECT id, authorName, counter, description, name, MAX(counter_read) AS mostRead\n" +
//            "FROM Book\n" +
//            "GROUP BY 1,2,3,4,5\n" +
//            "ORDER BY mostRead DESC")
    //List<Book> findMostReadBook();

    //List<Book> sortByMostRead();
//

//    @Query("SELECT name, description, counter, authorName FROM Book WHERE authorName LIKE :text")
//    List<Book> findSimilar(String text);
}
