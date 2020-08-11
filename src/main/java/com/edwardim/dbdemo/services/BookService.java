package com.edwardim.dbdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edwardim.dbdemo.models.Book;
import com.edwardim.dbdemo.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
//	GETTING A LIST OF ALL BOOKS
	public List<Book> getAllBooks(){
		return this.bookRepo.findAll();
	}
//	CREATING A BOOK
	public Book createBook(Book b) {
		return this.bookRepo.save(b);
	}
//	RETREIVING A BOOK BY ITS ID
	public Book getBookById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
//		1. GRAB BOOK FROM DB USING ID
		Book book = this.getBookById(id);
//		2. USE SETTERS TO CHANGE ATTRIBUTES OF BOOK
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumOfPages(numOfPages);
//		3. SAVE THE CHANGES INTO DB
		return this.bookRepo.save(book);
	}
//	DELETING A BOOK BY ID
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		this.bookRepo.deleteById(id);
	}
}
