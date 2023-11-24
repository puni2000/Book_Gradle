package com.heraizen.book.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heraizen.book.domain.Book;
import com.heraizen.book.repo.BookRepo;
import com.heraizen.book.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepo repo;

	@Override
	public String addBook(Book book) {
		String message = repo.save(book,false);
		return message;
	}

	@Override
	public List<Book> getAllBook() {
		return repo.getAllBooks();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		return repo.getBookByIsbn(isbn);
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		return repo.getBooksByAuthor(author);
	}

	@Override
	public List<Book> getBooksByPublishDetails(Integer publicationYear, String publisher) {
		// TODO Auto-generated method stub
		return repo.getBooksByPublishDetails(publicationYear, publisher);
	}

	@Override
	public String updateBook(String isbn,Book book,Boolean update) {
		update = true;
		Book b = repo.getBookByIsbn(isbn);

		if(b!=null) {
			b.setIsbn(book.getIsbn());
			b.setDescription(book.getDescription());
			b.setAuthor(book.getAuthor());
			b.setAuthorId(book.getAuthorId());
			b.setPages(book.getPages());
			b.setPublicationYear(book.getPublicationYear());
			b.setPublisher(book.getPublisher());
			b.setTitle(book.getTitle());
			b.setVolume(book.getVolume());

			String message  = repo.save(b,update);

			return "message";
		}
		else {
			return "Book cannot be empty";
		}

	}

	@Override
	public String deleteBookByIsbn(String isbn) {
		return repo.deleteBookByIsbn(isbn);
	}

	@Override
	public String deleteBasedOnAuthorAndPublishedYear(Integer publicationYear, String author) {
		return repo.deleteBasedOnAuthorAndPublishedYear(publicationYear, author);	
	}

	@Override
	public List<Book> getBooksByPublisgerAndPages(String publisher, Integer pages) {
		// TODO Auto-generated method stub
		return repo.getBooksByPublisgerAndPages(publisher, pages);
	}

}
