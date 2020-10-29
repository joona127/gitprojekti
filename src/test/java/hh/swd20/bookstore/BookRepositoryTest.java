package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(SpringExtension.class)  
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
    private BookRepository repository;

    @Test  // testataan BookRepositoryn findByAuthor()-metodin toimivuutta
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("Joona Sorjonen");
        
        assertThat(books).hasSize(2);
        assertThat(books.get(0).getTitle()).isEqualTo("Sienikirja");
    }
    
    @Test // testataan BookRepositoryn save()-metodin toimivuutta
    public void createNewBook() {
    	Book book = new Book("Kalakirja", "Joona Sorjonen", 1999, "930-289-203", null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}
	

