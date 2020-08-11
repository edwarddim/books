package com.edwardim.dbdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edwardim.dbdemo.models.Book;
import com.edwardim.dbdemo.services.BookService;

@RestController
public class BooksApi {
	
    private final BookService bookService;
    
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.getAllBooks();
    }
    
//    @RequestMapping(value="/api/books", method=RequestMethod.POST)
//    CREATING A BOOK
    @PostMapping("/api/books")
    public Book create(@RequestParam(value="title") String title, 
    					@RequestParam(value="description") String desc, 
    					@RequestParam(value="language") String lang, 
    					@RequestParam(value="pages") Integer numOfPages) {
        Book newBook = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(newBook);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        return book;
    }
    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    UPDATING A BOOK
    @PutMapping("/api/books/{id}")
    public Book update(@PathVariable("id") Long id, 
    					@RequestParam(value="title") String title, 
    					@RequestParam(value="description") String desc, 
    					@RequestParam(value="language") String lang, 
    					@RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    @DeleteMapping("/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
    
}
