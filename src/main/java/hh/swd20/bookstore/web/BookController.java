package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.Category;


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
import hh.swd20.bookstore.domain.CategoryRepository;



@Controller
public class BookController {
        @Autowired
		private BookRepository bookrepository;
        @Autowired
        private CategoryRepository crepository;
		
		@RequestMapping("/booklist")
		public String bookList(Model model) {
		     model.addAttribute("books", bookrepository.findAll());
			
			return "booklist";
		}
		
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", crepository.findAll());
			return "addbook";
		}
		
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookId, Model model) {
			bookrepository.deleteById(bookId);
			return "redirect:../booklist";
		}
		
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Book book) {
			bookrepository.save(book);
			return "redirect:booklist";
		}
}
