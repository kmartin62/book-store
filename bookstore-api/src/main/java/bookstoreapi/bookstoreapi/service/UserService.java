package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.model.security.UserRole;

import java.util.Optional;
import java.util.Set;

/**
 * Created by @kmartin62
 */
public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);

    Optional<User> findById(Long id) throws Exception;

}
