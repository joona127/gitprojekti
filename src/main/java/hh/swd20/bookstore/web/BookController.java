package hh.swd20.bookstore.web;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.Category;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.web.bind.annotation.CrossOrigin;

import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.UserRepository;


@CrossOrigin
@Controller
public class BookController {
        @Autowired
		private BookRepository bookrepository;
        @Autowired
        private CategoryRepository crepository;
        
        
        // Login page
        @RequestMapping(value="/login")
        public String login() {
        	return "login";
        }
		
		@RequestMapping("/booklist")
		public String bookList(Model model) {
		     model.addAttribute("books", bookrepository.findAll());
			
			return "booklist";
		}
		 //Restful service to get all the books
		 @RequestMapping(value="/books", method = RequestMethod.GET)
		    public @ResponseBody List<Book> bookListRest() {	
		        return (List<Book>) bookrepository.findAll();
		    }   
		 
		// Restful service to get book by id
		    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
		    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
		    	return bookrepository.findById(id);
		    }    
		    
		// Restful service to save a new book
		    @RequestMapping(value="/books", method = RequestMethod.POST)
		    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
		    	return bookrepository.save(book);
		    }
		@RequestMapping(value = "/add")
		public String addBook(Model model) {
			model.addAttribute("book", new Book());
			model.addAttribute("categories", crepository.findAll());
			return "addbook";
		}
		@PreAuthorize("hasAuthority('ADMIN')")
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
