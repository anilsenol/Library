package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
   
    
    List<Book> findByAuthorFullName(String fullName);
    
    @Query("SELECT b FROM Book b WHERE LOWER(b.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Book> getBooksbyName(String name);

    
    

}
