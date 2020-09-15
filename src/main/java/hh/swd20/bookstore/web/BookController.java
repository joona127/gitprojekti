package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.Book;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {

		
		
		@RequestMapping(value="/index", method = RequestMethod.GET)
		public String getBooks(Model model) {
			Book book = new Book();
			
			model.addAttribute("books", book);
			
			return "books";
		}
}
