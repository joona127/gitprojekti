package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.Book;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {

		
		
		@GetMapping("/index")
		public String getBooks(Model model) {
		     model.addAttribute("message", "Welcome to the book store!");
			
			return "books";
		}
}
