package hh.swd20.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b = new Book("Sienikirja", "Joona Sorjonen", 2010, "981-281-211");
			Book b2 = new Book("Kasvikirja", "Joona Sorjonen", 2011, "758-333-727");
			
			repository.save(b);
			repository.save(b2);
		};
	}
	
}
