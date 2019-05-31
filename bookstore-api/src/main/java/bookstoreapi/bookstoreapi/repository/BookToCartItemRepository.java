package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.BookToCartItem;
import bookstoreapi.bookstoreapi.model.CartItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by @kmartin62
 */
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
