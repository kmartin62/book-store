package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.BillingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long> {
}
