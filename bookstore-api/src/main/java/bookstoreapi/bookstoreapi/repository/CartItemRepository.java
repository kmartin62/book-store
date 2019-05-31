package bookstoreapi.bookstoreapi.repository;

import bookstoreapi.bookstoreapi.model.CartItem;
import bookstoreapi.bookstoreapi.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by @kmartin62
 */
@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//	List<CartItem> findByOrder(Order order);
}
