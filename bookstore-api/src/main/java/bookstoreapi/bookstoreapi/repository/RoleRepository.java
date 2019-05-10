package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
