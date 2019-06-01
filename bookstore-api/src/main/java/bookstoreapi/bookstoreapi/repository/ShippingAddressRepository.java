package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.ShippingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
}
