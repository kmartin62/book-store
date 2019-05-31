package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.Book;
import bookstoreapi.bookstoreapi.model.CartItem;
import bookstoreapi.bookstoreapi.model.ShoppingCart;
import bookstoreapi.bookstoreapi.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
public interface CartItemService {

    CartItem addBookToCartItem(Book book, User user, int qty);

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//	List<CartItem> findByOrder(Order order);

    CartItem updateCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    Optional<CartItem> findById(Long id);

    CartItem save(CartItem cartItem);

}
