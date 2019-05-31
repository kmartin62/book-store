package bookstoreapi.bookstoreapi.service.impl;

import bookstoreapi.bookstoreapi.model.*;
import bookstoreapi.bookstoreapi.repository.BookToCartItemRepository;
import bookstoreapi.bookstoreapi.repository.CartItemRepository;
import bookstoreapi.bookstoreapi.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private BookToCartItemRepository bookToCartItemRepository;

    public CartItem addBookToCartItem(Book book, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (book.getId() == cartItem.getBook().getId()) {
                cartItem.setQty(cartItem.getQty()+qty);
                cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setBook(book);
        cartItem.setQty(qty);
        cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(qty)));

        cartItem =cartItemRepository.save(cartItem);

        BookToCartItem bookToCartItem = new BookToCartItem();
        bookToCartItem.setBook(book);
        bookToCartItem.setCartItem(cartItem);
        bookToCartItemRepository.save(bookToCartItem);

        return cartItem;
    }

    @Transactional
    public void removeCartItem(CartItem cartItem) {
        bookToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_EVEN);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;

    }

    public Optional<CartItem> findById(Long id) {
        return cartItemRepository.findById(id);
    }

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }


//  public List<CartItem> findByOrder(Order order) {
//		return cartItemRepository.findByOrder(order);
//	}
}
