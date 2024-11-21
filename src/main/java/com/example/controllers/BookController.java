package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.entities.Book;
import com.example.services.BookService;

@RestController
@RequestMapping("/rest/api/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping( path = "/save")
	public Book saveBook(@RequestBody Book newBook) {
		return bookService.saveBook(newBook);
	}
	
	@GetMapping("/getBooks")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getByAuthor")
	public List<Book> getBooksByAuthor(@RequestParam String fullName){
		return bookService.getBookbyAuthor(fullName);
	}
	
	@GetMapping("/searchBook")
	public List<Book> getBooksbyName(@RequestParam String name){
		return bookService.getBooksbyName(name);
	}
	
	@DeleteMapping("/deleteBook")
	public void deleteBook(@RequestParam int id) {
		bookService.deleteBook(id);
	}
	
}
