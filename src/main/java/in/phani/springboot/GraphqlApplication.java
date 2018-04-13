package in.phani.springboot;

import in.phani.springboot.pojo.Book;
import in.phani.springboot.repository.BookRepository;

import com.google.common.collect.Lists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public boolean loadData(BookRepository bookRepository) {
		Book book1 = Book.builder().isbn("1").publisher("pub1").title("tit1").authors(Lists.newArrayList("auth1")).publishedDate(new Date()).build();
		Book book2 = Book.builder().isbn("2").publisher("pub2").title("tit2").authors(Lists.newArrayList("auth1", "auth2")).publishedDate(new Date()).build();
		Book book3 = Book.builder().isbn("3").publisher("pub3").title("tit3").authors(Lists.newArrayList("auth3")).publishedDate(new Date()).build();
		bookRepository.saveAll(Lists.newArrayList(book1, book2, book3));
		return true;
	}
}
