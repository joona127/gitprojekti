package hh.swd20.bookstore;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.web.BookController;



@ExtendWith(SpringExtension.class)   
@SpringBootTest
class BookstoreApplicationTests {

	

		@Autowired
		private BookController bookController;
		
		@Test
		public void contextLoads() {
			assertThat(bookController).isNotNull();
		}

	}


