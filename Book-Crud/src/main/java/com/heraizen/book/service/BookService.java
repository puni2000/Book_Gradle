package com.heraizen.book.service;

import java.util.List;

import com.heraizen.book.domain.Book;

public interface BookService {

	String addBook(Book book);
	
	List<Book> getAllBook();
	
	Book getBookByIsbn(String isbn);
	
	List<Book> getBooksByAuthor(String author);

	List<Book> getBooksByPublishDetails(Integer publicationYear, String publisher);
	
	String updateBook(String isbn,Book book,Boolean update);
	
	String deleteBookByIsbn(String isbn);
	
	String deleteBasedOnAuthorAndPublishedYear(Integer publicationYear,String author);
	
	List<Book> getBooksByPublisgerAndPages(String publisher,Integer pages);
}
