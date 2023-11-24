
package com.heraizen.book.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.heraizen.book.domain.Book;

@Repository
public class BookRepo {

	public List<Book> books = new ArrayList<Book>();

	public String save(Book book,Boolean update) {
		if(book!=null && book.getIsbn()!=null) {
			books.add(book);

			if(update.equals(true)) return "updated Successfully";
			else return "Added Successfully";
		}
		else {
			return "Book cannot be empty";
		}
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public Book getBookByIsbn(String isbn) {
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)){
				return b;
			}  
		}
		return null;

		//		return books.stream()
		//                .filter(book -> book.getIsbn().equals(isbn))
		//                .findFirst();
		
//		return books.stream().filter(c -> c.getIsbn() != null && c.getIsbn().equals(isbn)).findAny();
	}

	public List<Book> getBooksByAuthor(String author){
		List<Book> authorBookList = new ArrayList<Book>();
		for(Book b : books) {
			if(b.getAuthor().equals(author)) {
				authorBookList.add(b);
			}
		}
		return authorBookList;
	}


	public List<Book> getBooksByPublishDetails(Integer publicationYear, String publisher){
		List<Book> authorBookList = new ArrayList<Book>();
		for(Book b : books) {
			if(b.getPublicationYear().equals(publicationYear) && b.getPublisher().equals(publisher)) {
				authorBookList.add(b);
			}
		}
		return authorBookList;
	}


	public String  deleteBookByIsbn(String isbn) {
		Book b = getBookByIsbn(isbn);

		if(b!=null) {
			books.remove(b);
			return "deleted successfully";
		}
		else {
			return "Book not found";
		}
	}


	public String deleteBasedOnAuthorAndPublishedYear(Integer publicationYear, String author) {
		List<Book> b = new ArrayList<Book>();

		for(Book b1 : books) {
			if(b1.getPublicationYear().equals(publicationYear) && b1.getAuthor().equals(author)) {
				b.add(b1);
			}
		}

		if(!b.isEmpty()) { 
			books.removeAll(b);

			return "Deleted Successfully";
		}
		else return "Book Not Found";
	}

	public List<Book> getBooksByPublisgerAndPages(String publisher,Integer pages){
		List<Book> b = new ArrayList<Book>();

		for(Book b1 : books) {
			if(b1.getPublisher().equals(publisher) && b1.getPages()>=(pages)) {
				b.add(b1);
			}
		}

		return b;
	}
}
