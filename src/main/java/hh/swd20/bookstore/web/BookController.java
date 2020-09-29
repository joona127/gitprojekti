package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.Book;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.BookRepository;


@Controller
public class BookController {
        @Autowired
		private BookRepository repository;
		
		@RequestMapping("/booklist")
		public String bookList(Model model) {
		     model.addAttribute("books", repository.findAll());
			
			return "booklist";
		}
		
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			return "addbook";
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model) {
			repository.deleteById(bookId);
			return "redirect:../booklist";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Book book) {
			repository.save(book);
			return "redirect:booklist";
		}
}
