package com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Author;
import com.example.services.AuthorService;

@RestController
@RequestMapping("/rest/api/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@PostMapping( path = "/save")
	public Author saveAuthor(@RequestBody Author newAuthor) {
		return authorService.saveAuthor(newAuthor);
	}
	
	@GetMapping("/getById")
	public Optional<Author> getAuthorById(@RequestParam Integer id) {
		return authorService.getAuthoById(id);
	}
	
}
