package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.domain.User;
import bookstoreapi.bookstoreapi.domain.security.UserRole;

import java.util.Set;

/**
 * Created by @kmartin62
 */
public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
