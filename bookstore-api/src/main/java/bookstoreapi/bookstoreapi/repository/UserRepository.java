package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
