package in.phani.springboot.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import in.phani.springboot.pojo.Book;
import in.phani.springboot.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecificBookFetcher implements DataFetcher<Book> {

  private final BookRepository bookRepository;

  @Autowired
  public SpecificBookFetcher(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book get(DataFetchingEnvironment dataFetchingEnvironment) {
    String isbn = dataFetchingEnvironment.getArgument("isbn");
    return bookRepository.findByIsbn(isbn);
  }
}
