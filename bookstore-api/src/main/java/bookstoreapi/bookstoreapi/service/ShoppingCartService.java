package bookstoreapi.bookstoreapi.service;

import bookstoreapi.bookstoreapi.model.ShoppingCart;

/**
 * Created by @kmartin62
 */
public interface ShoppingCartService {
    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);
}
