package com.example.entities;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Book {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_of_published")
	private String dateOfPublished;
	
	@Column(name = "page")
	private String page;
	
	@ManyToOne
	@JoinColumn(name = "author_id") 
	private Author author;
	
}
