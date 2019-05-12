package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
}
