package in.phani.springboot.repository;

import in.phani.springboot.pojo.Book;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
  Book findByIsbn(String isbn);
}
