package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Author;
import com.example.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author saveAuthor(Author newAuthor) {
		return authorRepository.save(newAuthor);
	}
	
	public Optional<Author> getAuthoById(Integer id) {
		return authorRepository.findById(id);
	}
}
