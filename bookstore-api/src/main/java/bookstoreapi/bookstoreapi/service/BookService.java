package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
public interface BookService {

    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    List<Book> findByTitle(String title);
    void removeById(Long id);
}
