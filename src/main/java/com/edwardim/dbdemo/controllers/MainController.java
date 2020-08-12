package com.edwardim.dbdemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.edwardim.dbdemo.models.Book;
import com.edwardim.dbdemo.services.BookService;

@Controller
public class MainController {
	
	@Autowired
	private BookService bookServ;
	
	

	
// -------------	CREATING A BOOK -------------------------- //
	// RENDERING THE CREATE PAGE
	@GetMapping("/books/new")
	public String create(@ModelAttribute("bookObj") Book book ) {
		return "new.jsp";
	}
	// PROCESSING CREATION OF OBJ
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("bookObj") Book book ,BindingResult results) {
		if(results.hasErrors()) {
			return "new.jsp";
		}
		else {
			bookServ.createBook(book);
			return "redirect:/dashboard";
		}
	}
// -------------	UPDATING A BOOK -------------------------- //
	// RENDERING THE EDIT PAGE
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		// 1. RETRIEVE BOOK BY ID
		Book book = bookServ.getBookById(id);
		// 2. BIND BOOK FROM DB TO JSP
		model.addAttribute("bookObj", book);
		return "edit.jsp";
	}
	// PROCESSING UPDATE OF OBJ
	@PutMapping("/books/{id}/edit")
	public String editBook(@Valid @ModelAttribute("bookObj") Book book ,BindingResult results) {
		if(results.hasErrors()) {
			return "edit.jsp";
		}
		else {
			bookServ.createBook(book);
			return "redirect:/dashboard";
		}
	}

// -------------	RETRIEVE -------------------------- //
	// RETRIEIVING ALL BOOKS
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		// 1. GET ALL BOOKS FROM DB (SERVICE)
		List<Book> allBooks = bookServ.getAllBooks();
		// 2. PASS THAT INFO TO JSP (MODEL)
		model.addAttribute("allBooks", allBooks);
		return "dashboard.jsp";
	}
	// RETRIEVING A BOOK
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		// 1. GET ONE BOOK FROM DB(SERVICE)
		Book oneBook = bookServ.getBookById(id);
		// 2. PASS THAT INFO TO JSP(MODEL)
		model.addAttribute("book", oneBook);
		return "show.jsp";
	}

// -------------	DELETE -------------------------- //
	//	DELETING A BOOK
	@GetMapping("/books/{id}/delete")
	public String delete(@PathVariable("id")Long id) {
		bookServ.deleteBook(id);
		return "redirect:/dashboard";
	}
	
	
}
