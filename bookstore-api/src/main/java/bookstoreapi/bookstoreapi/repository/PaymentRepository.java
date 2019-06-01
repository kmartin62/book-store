package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.Payment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
