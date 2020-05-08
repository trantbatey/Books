package com.codeup.books.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    // The following method is equivalent to the built in `getOne` method, there's no need to create this example
    @Query("SELECT b FROM Book b WHERE b.id = ?1")
    Book getBookById(long id);

    // The following method shows you how to use named params in a HQL custom query:
    @Query("SELECT b FROM Book b where b.title like %:term%")
    List<Book> searchByTitleLike(@Param("term") String term);
}
