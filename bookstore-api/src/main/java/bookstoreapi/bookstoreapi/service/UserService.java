package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.User;
import bookstoreapi.bookstoreapi.model.security.UserRole;

import java.util.Set;

/**
 * Created by @kmartin62
 */
public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
