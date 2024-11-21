package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
