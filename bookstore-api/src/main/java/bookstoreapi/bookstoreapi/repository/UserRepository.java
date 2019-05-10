package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by @kmartin62
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}
