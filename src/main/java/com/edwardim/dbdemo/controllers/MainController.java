package com.edwardim.dbdemo.controllers;

import org.springframework.stereotype.Controller;

import com.edwardim.dbdemo.services.BookService;

@Controller
public class MainController {
	
	private final BookService bookServ;
	
	public MainController(BookService bookServ) {
		this.bookServ = bookServ;
	}
	
	
}
