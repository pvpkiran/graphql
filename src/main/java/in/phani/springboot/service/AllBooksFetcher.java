package in.phani.springboot.service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import in.phani.springboot.pojo.Book;
import in.phani.springboot.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllBooksFetcher implements DataFetcher<List<Book>> {

  private final BookRepository bookRepository;

  @Autowired
  public AllBooksFetcher(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) {
    return bookRepository.findAll();
  }
}
