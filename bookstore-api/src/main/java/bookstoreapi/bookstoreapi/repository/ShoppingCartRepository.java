package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
