package com.heraizen.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.heraizen.book.domain.Book;
import com.heraizen.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;

	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		return service.addBook(book);
	}

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return service.getAllBook();
	}

	@GetMapping("/getBookByIsbn/{isbn}")
	public Book getBookByIsbn(@PathVariable String isbn) {
		return service.getBookByIsbn(isbn);
	}

	@GetMapping("/getBooksByAuthor")
	public List<Book> getBookByAuthor(@RequestParam String author){
		return service.getBooksByAuthor(author);
	}
	
	@GetMapping("/published")
    public List<Book> getBooksByPublishDetails(
    		@RequestParam Integer publicationYear,
            @RequestParam String publisher) {

        return service.getBooksByPublishDetails(publicationYear, publisher);

    }
	
	@PutMapping("update/{isbn}")
	public String  update(@PathVariable String isbn,@RequestBody Book book,Boolean update) {
		update = true;
		return service.updateBook(isbn,book,update);
	}
	
	@DeleteMapping("/deleteBookByIsbn/{isbn}")
	public String  deleteBookByIsbn(@PathVariable String isbn) {
		return service.deleteBookByIsbn(isbn);
	}
	
	
	@DeleteMapping("/deleteBasedOnAuthorAndPublishedYear")
	public String deleteBasedOnAuthorAndPublishedYear(
			@RequestParam Integer publicationYear,
            @RequestParam String author) {
		return service.deleteBasedOnAuthorAndPublishedYear(publicationYear, author);
	}
	
	@GetMapping("/getBooksByPublisgerAndPages")
	public List<Book> getBooksByPublisgerAndPages(
			@RequestParam String publisher,
            @RequestParam Integer pages){
		
		return service.getBooksByPublisgerAndPages(publisher, pages);
	}
	
	@PostMapping("/uploadFiles")
    public String handleFileUpload(@RequestParam("file1") MultipartFile file1,
                                                  @RequestParam("file2") MultipartFile file2) {
        String fileName1 = file1.getOriginalFilename();
        String fileName2 = file2.getOriginalFilename();

        return "Files uploaded: " + fileName1 + ", " + fileName2;
    }
	
}
