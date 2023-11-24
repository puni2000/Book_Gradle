package com.heraizen.book.domain;

import org.springframework.stereotype.Component;

public class Book {
	
	
	private String isbn;
	private String title; 
	private String description; 
	private String volume; 
	private String author; 
	private String authorId; 
	private Integer pages; 
	private String publisher; 
	private Integer publicationYear;
	
	
	public Book() {
		super();
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getVolume() {
		return volume;
	}


	public void setVolume(String volume) {
		this.volume = volume;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}


	public Integer getPages() {
		return pages;
	}


	public void setPages(Integer pages) {
		this.pages = pages;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public Integer getPublicationYear() {
		return publicationYear;
	}


	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}


	public Book(String isbn, String title, String description, String volume, String author, String authorId,
			Integer pages, String publisher, Integer publicationYear) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.volume = volume;
		this.author = author;
		this.authorId = authorId;
		this.pages = pages;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
	}


	
	
	
}
