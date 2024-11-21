package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Author;
import com.example.entities.Book;
import com.example.repositories.AuthorRepository;
import com.example.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Book saveBook(Book newbBook){
		 Author author = authorRepository.findById(newbBook.getAuthor().getId())
		   .orElseThrow(() -> new RuntimeException("Author not found"));
		 newbBook.setAuthor(author);
		 return bookRepository.save(newbBook);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public List<Book> getBookbyAuthor(String fullName) {
		List<Book> books = bookRepository.findByAuthorFullName(fullName);
        if (books.isEmpty()) {
            throw new RuntimeException("No books found for author: " + fullName);
        }
        return books;
	}
	
	public List<Book> getBooksbyName(String name){
		List<Book> books = bookRepository.getBooksbyName(name);
		if(books.isEmpty()) {
			throw new RuntimeException("No books found for this name:  " + name);
		}
		return books;
	}
	
	public void deleteBook(int id) {
		 bookRepository.deleteById(id);
	}
	
	

}
