package in.phani.springboot.controller;

import graphql.ExecutionResult;
import in.phani.springboot.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(final BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping("/book")
  public Object getAllBooks(@RequestBody String query) {
    ExecutionResult execute = bookService.getGraphQL().execute(query);
    return execute.getData();
  }
}
