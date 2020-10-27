package hh.swd20.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
		    Category c = new Category("Nature book");
			Category c2 = new Category("Short story");
			Category c3 = new Category("Romance");
			
			crepository.save(c);
			crepository.save(c2);
			crepository.save(c3);
			
			Book b = new Book("Sienikirja", "Joona Sorjonen", 2010, "981-281-211", c);
			Book b2 = new Book("Kasvikirja", "Joona Sorjonen", 2011, "758-333-727", c);
			
			brepository.save(b);
			brepository.save(b2);
			
			User u = new User("joona127", "$2a$10$mDBZRQQHNkVmMED17RSNp.8.s0SHcMYRiq3qR3Nwk7oJKFk7gxJHe", "ADMIN");
			User u2 = new User("hoolappa", "$2a$10$NKMsD6FvC4BM05oLCxzjc.GUhkD51EpQYMiTX0wNyM3nIP1Ijy9bq", "USER");
			
			urepository.save(u);
			urepository.save(u2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
}
