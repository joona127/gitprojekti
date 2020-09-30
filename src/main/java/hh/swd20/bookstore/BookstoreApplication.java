package hh.swd20.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
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
		};
	}
	
}
