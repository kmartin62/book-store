package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.UserPayment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long > {
}
